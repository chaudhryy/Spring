package com.yash.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yash.beans.RestOcpClient;
import com.yash.cache.LocalCache;
import com.yash.exceptions.OcpException;
import com.yash.model.consumer.*;
import com.yash.provider.ocp.json.routelist.RouteListSuccessResponse;
import com.yash.swagger.config.ServiceDefinitionsContext;
import io.swagger.models.Swagger;
import io.swagger.models.Tag;
import io.swagger.parser.SwaggerParser;
import io.swagger.util.Json;
import io.swagger.util.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.converter.SwaggerConverter;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ApicRestService {

    @Autowired
    RestOcpClient client;

    @Autowired
    LocalCache cache;

    @Autowired
    ServiceDefinitionsContext context;



    public String getSwaggerList() {

            ConcurrentHashMap<String, Swagger> swaggerMap = context.getServiceDescriptionMap();
            SwaggerListModel responseModel = new SwaggerListModel();
        if (cache.getNamespace() != null) {
            responseModel.setOrganizationName(cache.getNamespace().toUpperCase());
            responseModel.setDefinition(new LinkedList<>());

            swaggerMap.forEach((key, swagger) -> {
                Definition definition = new Definition();
                responseModel.getDefinition().add(definition);
                definition.setName(swagger.getInfo().getTitle());
                definition.setSwaggerId(key);
                definition.setHostname(swagger.getHost());
                definition.setTags(new LinkedList<>());
                List<Tag> tags = swagger.getTags();
                if(!CollectionUtils.isEmpty(tags)){
                    tags.forEach((tag) ->{
                        definition.getTags().add(tag.getName());
                    });
                }

            });
        }
        return  responseModel.toString();

    }

    public String getSwagger(String swaggerId) {
        ConcurrentHashMap<String, Swagger> swaggerMap = context.getServiceDescriptionMap();
        Swagger swagger = swaggerMap.get(swaggerId);
        try {
           String json = Json.pretty().writeValueAsString(swagger).replace("---\n","");
            System.out.println("AAAAAAAAAAAAAA -----> " +json);
            return  json;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
    public String getOpenApi(String swaggerId) {
        ConcurrentHashMap<String, Swagger> swaggerMap = context.getServiceDescriptionMap();
        Swagger swagger = swaggerMap.get(swaggerId);
        try {

            String json = Json.pretty().writeValueAsString(swagger).replace("---\n","");
          SwaggerParseResult parseResult =  new SwaggerConverter().readContents(json,null,null);
            if (parseResult != null) {
                OpenAPI openAPi = parseResult.getOpenAPI();
                return Json.pretty().writeValueAsString(openAPi);
            }

            System.out.println("AAAAAAAAAAAAAA -----> " +json);
            return  "Could not Convert To OpenAPI spec";

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"Error\":\"Swagger 2.0 Could not be Converted to OpenApi\",\"Description\":\""+e.getMessage()+"\"}";
        }

    }

    public Oauth2Response login(UserLoginRequest request) throws OcpException {
        Oauth2Response response = null;
        if(!StringUtils.isNotBlank(request.getToken())) {
             response= client.login(request);
            getUserDetails(response);
        }else{
            response = new Oauth2Response();
            OAuth oAuth = new OAuth();
            response.setOAuth(oAuth);
            oAuth.setToken(request.getToken());
            response.setType(request.getType());
            getUserDetails(response);

        }


        return response;
    }

    private void getUserDetails(Oauth2Response response) throws OcpException {
            UserDetailsResponse usResponse = client.getUserDetails(response);
            response.setFullName(usResponse.getFullName());
            response.setClienId(usResponse.getMetadata().getName());

    }



}
