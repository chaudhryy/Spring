package com.yash.service.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.beans.CommonConfiguration;
import com.yash.exceptions.OcpException;
import com.yash.model.consumer.Oauth2Response;
import com.yash.model.consumer.UserLoginRequest;
import com.yash.service.ApicRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AppInterfaceSwagger {


    @Autowired
    ApicRestService service;

    @Autowired
    CommonConfiguration config;

    @Autowired
    ObjectMapper mapper;

    @GetMapping(value = "/app/swagger" , produces = "application/json")
        public String getAvailableSwaggerList() throws OcpException {
//        if(isRefresh){
//            service.execute();
//        }
        String response = service.getSwaggerList();
        System.out.println(" Response ==> " + response);
        return  response;
    }


    @PostMapping(value = "/ocp/login",produces = "application/json",consumes = "application/json")
    public String login(@RequestBody UserLoginRequest request) throws OcpException, JsonProcessingException {
        Oauth2Response response = service.login(request);
        // check and load if swagger is not already Loaded  . If not Initiate load
        config.loadSwagger(response.getOAuth().getToken());
        return mapper.writeValueAsString(response);
    }

    @GetMapping(value = "/app/swagger/{swaggerId}" , produces = "application/json" )
    public String  getSwaggerAndRefresh(@PathVariable(name ="swaggerId" ,required = true) String swaggerId ){

        return service.getSwagger(swaggerId);
    }
    @GetMapping(value = "/app/openapi/{swaggerId}" , produces = "application/json" )
    public String  getOpenApi(@PathVariable(name ="swaggerId" ,required = true) String swaggerId ){

        return service.getOpenApi(swaggerId);
    }
//    @GetMapping(value="/app/swagger/codegen/languages")
//    public String getCodeGenLanguages(){
//
//        return null;
//    }
}
