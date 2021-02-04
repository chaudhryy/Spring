package com.yash.beans;

import com.yash.cache.LocalCache;
import com.yash.exceptions.OcpException;
import com.yash.model.consumer.OAuth;
import com.yash.model.consumer.Oauth2Response;
import com.yash.model.consumer.UserDetailsResponse;
import com.yash.model.consumer.UserLoginRequest;
import com.yash.provider.ocp.json.routelist.RouteListSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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

    public String getSwaggerDefinitionForAPI(String serviceName, String url){
        try{
            String jsonData = restTemplate.getForObject(url, String.class);
            return jsonData;
        }catch(RestClientException ex){
            System.err.println(ex.getCause());
        }
        return null;
    }

    private String getUrl(String type){
        String url = null;
        switch (type){
            case "PROD":
                url= prodUrl;
                break;
            case "NPE":
                url= npeUrl;
                break;
            case "REG":
                url= regUrl;
        }
        System.out.println("Type " + type + " Url " +url);
        return  url;
    }


    private void checkStatusCode(HttpStatus statusCode) throws OcpException {

        switch (statusCode){
            case UNAUTHORIZED:
                cache.setAuthorization(null);
                throw new OcpException("Authorization is not set/expired");
            default:
                throw new OcpException(statusCode.getReasonPhrase());
        }
    }

    private  HttpEntity<?> getHeaders(String token) throws OcpException {

        String auth=StringUtils.isEmpty(token)?cache.getAuthorization():token;
        if(StringUtils.isEmpty(auth)){
            throw new OcpException("Authorization is not set/expired");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+auth);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return entity;
    }
    private void checkNamespace() throws OcpException {
        if(StringUtils.isEmpty(cache.getNamespace())){
            throw new OcpException("Namespace/Project not set");
        }
    }

    public ResponseEntity<RouteListSuccessResponse> getRouteList() throws OcpException {
        HttpEntity<?> entity = getHeaders(null);
        checkNamespace();
        ResponseEntity<RouteListSuccessResponse> responseList = restTemplate.exchange(getUrl("NPE")+"/oapi/v1/namespaces/"+cache.getNamespace()+"/routes", HttpMethod.GET,entity, RouteListSuccessResponse.class);
        //  checkStatusCode(responseList.getStatusCode());
        return  responseList;
    }

    public String getRestSwagger(String host) throws OcpException {
        try {

            String respose= restTemplate.getForObject("http://"+host,String.class);

            return  respose;
        } catch (RestClientException e) {
            System.out.println("Exception " + e.getLocalizedMessage());
            return "Fetch-Exception :: "+e.getLocalizedMessage();
        }
//        return null;
    }

    public String getCxfServiceList(String host) {
        try {

            String respose= restTemplate.getForObject("http://"+host,String.class);

            return  respose;
        } catch (RestClientException e) {
            System.out.println("Exception " + e.getLocalizedMessage());
            return "Fetch-Exception :: "+e.getLocalizedMessage();
        }
    }

    public Oauth2Response getAuthForUrl(UserLoginRequest request) {
        HttpHeaders headers = new HttpHeaders();
        String token = UUID.randomUUID().toString();
        headers.set("X-CSRF-Token",token);
        headers.set("Authorization","Basic "+request.getAuthorization());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUrl(request.getType())+"/oauth/authorize?response_type=token&client_id=openshift-challenging-client")
                    .queryParam("response_type","token")
                    .queryParam("client_id","openshift-challenging-client");

            ResponseEntity<?> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity,String.class);

            Oauth2Response ocpToken = getTokenResponse(response);
            return ocpToken;
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Oauth2Response getTokenResponse(ResponseEntity<?> response) {
        Oauth2Response oauth2Response = new Oauth2Response();
        HttpHeaders headers = response.getHeaders();
        List<String> headersList = headers.get("Location");
        System.out.println("HeaderList " + headersList);
        if(headersList != null && headersList.size()>0){
            String locationUrl = headersList.get(0);
            MultiValueMap<String, String> parameters =
                    UriComponentsBuilder.fromUriString(locationUrl.replace("#","?")).build().getQueryParams();
            List<String> accessToken = parameters.get("access_token");
            OAuth oAuth = new OAuth();
            oauth2Response.setOAuth(oAuth);

            if (accessToken != null && accessToken.size()>0) {

                oAuth.setToken(accessToken.get(0));
            }
            List<String> expiresIn = parameters.get("expires_in");
            if (expiresIn != null && expiresIn.size()>0) {
                oAuth.setExpiration(expiresIn.get(0));
            }

        }
        return oauth2Response;
    }

    public Oauth2Response login(UserLoginRequest request) {
        Oauth2Response response = getAuthForUrl(request);
        response.setType(request.getType());
        return  response;
    }

    public UserDetailsResponse getUserDetails(Oauth2Response response) throws OcpException {
        HttpEntity<?> entity = getHeaders(response.getOAuth().getToken());
        ResponseEntity<UserDetailsResponse> responseList = restTemplate.exchange(getUrl(response.getType())+"/oapi/v1/users/~", HttpMethod.GET,entity, UserDetailsResponse.class);
        //  checkStatusCode(responseList.getStatusCode());
        return  responseList.getBody();

    }
}
