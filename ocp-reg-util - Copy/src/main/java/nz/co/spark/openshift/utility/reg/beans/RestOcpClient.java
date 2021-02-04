package nz.co.spark.openshift.utility.reg.beans;

import nz.co.spark.openshift.utility.reg.cache.LocalCache;
import nz.co.spark.openshift.utility.reg.exceptions.OcpException;
import nz.co.spark.openshift.utility.reg.model.EnvTypeEnum;
import nz.co.spark.openshift.utility.reg.model.ResponseOCPAuthToken;
import nz.co.spark.openshift.utility.reg.ocp.db.model.ImageStreamTagListEntity;
import nz.co.spark.openshift.utility.reg.provider.ocp.json.registry.ImageStreamTags;
import nz.co.spark.openshift.utility.reg.provider.ocp.json.dclist.DcSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Component
public class RestOcpClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LocalCache cache;

    @Value("${ocp.npe.provider.endpoint}")
    private String npeUrl;

    @Value("${ocp.prod.provider.endpoint}")
    private String prodUrl;

    @Value("${ocp.reg.provider.endpoint}")
    private String regUrl;

    @Value("${ocp.reg.delete.url.log:true}")
    private boolean enableDeleteURLLog;

    @Value("${ocp.reg.delete.enable:false}")
    private boolean enableDelete;

    private String getUrl(EnvTypeEnum type){
        switch (type){
            case PROD:
                return prodUrl;
            case NPE:
                 return npeUrl;
            case REG:
                return regUrl;
        }
        return  null;
    }


    private void checkStatusCode(HttpStatus statusCode,EnvTypeEnum type) throws OcpException {

        switch (statusCode){
            case UNAUTHORIZED:
                cache.setAuthorization(null,type);
                throw new OcpException("Authorization is not set/expired");
            default:
                throw new OcpException(statusCode.getReasonPhrase());
        }
    }

    private  HttpEntity<?> getHeaders(EnvTypeEnum type) throws OcpException {

        String auth=cache.getAuthorization(type);
        if(StringUtils.isEmpty(auth)){
            auth = getAuthForUrl(type);
        }
        if(StringUtils.isEmpty(auth)){
            throw new OcpException("Authorization is not set/expired");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+auth);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return entity;
    }

    public String getAuthForUrl(EnvTypeEnum type) {
        String url = getUrl(type);
        HttpHeaders headers = new HttpHeaders();
        String originalInput = cache.getUsername()+":"+cache.getPassword();
        String auth = Base64.getEncoder().encodeToString(originalInput.getBytes());
        String token = UUID.randomUUID().toString();
        headers.set("X-CSRF-Token",token);
        headers.set("Authorization","Basic "+auth);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        try {
            // /oauth/authorize?response_type=token&client_id=openshift-challenging-client
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/oauth/authorize")
                    .queryParam("response_type","token")
                    .queryParam("client_id","openshift-challenging-client");

            ResponseEntity<?> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity,String.class);

            ResponseOCPAuthToken ocpToken = getTokenResponse(response);
            cache.setAuthorization(ocpToken,type);
            return ocpToken.getAccessToken();
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResponseOCPAuthToken getTokenResponse(ResponseEntity<?> response) {

        HttpHeaders headers = response.getHeaders();
        List<String> headersList = headers.get("Location");
        if(headersList != null && headersList.size()>0){
            String locationUrl = headersList.get(0);
            MultiValueMap<String, String> parameters =
                    UriComponentsBuilder.fromUriString(locationUrl.replace("#","?")).build().getQueryParams();
                    ResponseOCPAuthToken responseOauthToken = new ResponseOCPAuthToken();
                    List<String> accessToken = parameters.get("access_token");
                        if (accessToken != null && accessToken.size()>0) {
                            responseOauthToken.setAccessToken(accessToken.get(0));
                        }
                    List<String> expiresIn = parameters.get("expires_in");
                    if (expiresIn != null && expiresIn.size()>0) {
                        responseOauthToken.setExpiresIn(expiresIn.get(0));
                    }

                    List<String> tokenType = parameters.get("token_type");
                    if (tokenType != null && tokenType.size()>0) {
                        responseOauthToken.setTokenType(tokenType.get(0));
                    }
                    return responseOauthToken;
        }
        return null;
    }

    private void checkNamespace() throws OcpException {
        if(StringUtils.isEmpty(cache.getNamespace())){
            throw new OcpException("Namespace/Project not set");
        }
    }




    public ResponseEntity<DcSuccessResponse> getDCList(EnvTypeEnum type) throws OcpException {
        HttpEntity<?> entity = getHeaders(type);
        checkNamespace();
        ResponseEntity<DcSuccessResponse> responseList = restTemplate.exchange(getUrl(type)+"/oapi/v1/namespaces/"+cache.getNamespace()+"/deploymentconfigs", HttpMethod.GET,entity, DcSuccessResponse.class);
        //  checkStatusCode(responseList.getStatusCode());
        return  responseList;
    }


    public ImageStreamTags getDockerRegistry(EnvTypeEnum type) throws OcpException {
        HttpEntity<?> entity = getHeaders(type);
        checkNamespace();
        ResponseEntity<ImageStreamTags> responseList = restTemplate.exchange(getUrl(type)+"/apis/image.openshift.io/v1/namespaces/"+cache.getNamespace()+"/imagestreamtags", HttpMethod.GET,entity, ImageStreamTags.class);
        //  checkStatusCode(responseList.getStatusCode());
        return responseList.getBody();
    }

    public void deleteImageStreamstags(List<ImageStreamTagListEntity> imageStreamListEntity,EnvTypeEnum type) throws OcpException {
        HttpEntity<?> entity = getHeaders(type);
        checkNamespace();
        for(ImageStreamTagListEntity imageStream: imageStreamListEntity){
           // /apis/image.openshift.io/v1/namespaces/$NAMESPACE/imagestreamtags/$NAME
            if (!StringUtils.isEmpty(imageStream.getName())) {
                if (enableDeleteURLLog) {
                    System.out.println("<DELETE> "+getUrl(type)+"/apis/image.openshift.io/v1/namespaces/"+cache.getNamespace()+"/imagestreamtags/"+imageStream.getName());
                }
                if(enableDelete) {
                    ResponseEntity<Object> responseEntity = restTemplate.exchange(getUrl(type) + "111/apis/image.openshift.io/v1/namespaces11/" + cache.getNamespace() + "/imagestreamtags/" + imageStream.getName(), HttpMethod.DELETE, entity, Object.class);
                }

            }

        }

    }
}
