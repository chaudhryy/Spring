package com.yash.beans;

import com.yash.cache.LocalCache;
import com.yash.exceptions.OcpException;
import com.yash.provider.ocp.json.CMlist.CMSuccessResponse;
import com.yash.provider.ocp.json.dclist.DcSuccessResponse;
import com.yash.provider.ocp.json.podlists.PodListSuccessResponse;
import com.yash.provider.ocp.json.projectlist.ProjectResponseList;
import com.yash.provider.ocp.json.routelist.RouteListSuccessResponse;
import com.yash.provider.ocp.json.secretlist.SecretSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestOcpClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LocalCache cache;

    @Value("${ocp.provider.endpoint}")
    private String url;

    public ResponseEntity<ProjectResponseList> getProjectList() throws OcpException {
            HttpEntity<?> entity = getHeaders();
            ResponseEntity<ProjectResponseList> responseList = restTemplate.exchange(url+"/oapi/v1/projects", HttpMethod.GET,entity, ProjectResponseList.class);
          //  checkStatusCode(responseList.getStatusCode());
            return  responseList;
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

    private  HttpEntity<?> getHeaders() throws OcpException {

        String auth=cache.getAuthorization();
        if(StringUtils.isEmpty(auth)){
            throw new OcpException("Authorization is not set/expired");
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+auth);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return entity;
    }

    public ResponseEntity<PodListSuccessResponse> getPodList() throws OcpException {
        HttpEntity<?> entity = getHeaders();
        checkNamespace();
        ResponseEntity<PodListSuccessResponse> responseList = restTemplate.exchange(url+"/api/v1/namespaces/"+cache.getNamespace()+"/pods", HttpMethod.GET,entity, PodListSuccessResponse.class);
        //  checkStatusCode(responseList.getStatusCode());
        return  responseList;
    }

    private void checkNamespace() throws OcpException {
        if(StringUtils.isEmpty(cache.getNamespace())){
            throw new OcpException("Namespace/Project not set");
        }
    }


    public ResponseEntity<DcSuccessResponse> getDCList() throws OcpException {
        HttpEntity<?> entity = getHeaders();
        checkNamespace();
        ResponseEntity<DcSuccessResponse> responseList = restTemplate.exchange(url+"/oapi/v1/namespaces/"+cache.getNamespace()+"/deploymentconfigs", HttpMethod.GET,entity, DcSuccessResponse.class);
        //  checkStatusCode(responseList.getStatusCode());
        return  responseList;
    }

    public ResponseEntity<SecretSuccessResponse> getSecretList() throws OcpException {
        HttpEntity<?> entity = getHeaders();
        checkNamespace();
        ResponseEntity<SecretSuccessResponse> responseList = restTemplate.exchange(url+"/api/v1/namespaces/"+cache.getNamespace()+"/secrets", HttpMethod.GET,entity, SecretSuccessResponse.class);
        //  checkStatusCode(responseList.getStatusCode());
        return  responseList;
    }

    public ResponseEntity<CMSuccessResponse> getConfigMapList() throws OcpException {
        HttpEntity<?> entity = getHeaders();
        checkNamespace();
        ResponseEntity<CMSuccessResponse> responseList = restTemplate.exchange(url+"/api/v1/namespaces/"+cache.getNamespace()+"/configmaps", HttpMethod.GET,entity, CMSuccessResponse.class);
        //  checkStatusCode(responseList.getStatusCode());
        return  responseList;
    }

    public ResponseEntity<RouteListSuccessResponse> getRouteList() throws OcpException {
        HttpEntity<?> entity = getHeaders();
        checkNamespace();
        ResponseEntity<RouteListSuccessResponse> responseList = restTemplate.exchange(url+"/oapi/v1/namespaces/"+cache.getNamespace()+"/routes", HttpMethod.GET,entity, RouteListSuccessResponse.class);
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
}
