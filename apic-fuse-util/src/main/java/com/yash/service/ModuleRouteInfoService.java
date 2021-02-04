package com.yash.service;

import com.yash.beans.RestOcpClient;
import com.yash.cache.LocalCache;
import com.yash.exceptions.OcpException;
import com.yash.provider.ocp.json.routelist.Item;
import com.yash.provider.ocp.json.routelist.RouteListSuccessResponse;
import com.yash.swagger.config.ServiceDefinitionsContext;
import io.swagger.models.Swagger;
import io.swagger.parser.Swagger20Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@Service
public class ModuleRouteInfoService {

    @Autowired
    LocalCache cache;

    @Autowired
    RestOcpClient client;

    @Autowired
    ServiceDefinitionsContext definitionContext;

    private AtomicBoolean isLoading = new AtomicBoolean(false);

    public void transformSwagger(String basePath, RouteListSuccessResponse responseList) throws OcpException {
                List<String> fileNameList = new LinkedList<>();
        if (isLoading.compareAndSet(false,true)) {
            if(responseList != null && !CollectionUtils.isEmpty(responseList.getItems())){
                for(Item item : responseList.getItems()){
                    if(item.getMetadata().getName().contains("rest")) {
                        try {
                            String responseResponseEntity = client.getRestSwagger(item.getSpec().getHost());
                            if (responseResponseEntity != null && !responseResponseEntity.contains("Fetch-Exception")) {

                                Swagger swagger = new Swagger20Parser().parse(responseResponseEntity);
                                swagger.setHost(item.getSpec().getHost());
                                if (swagger == null) {
                                    continue;
                                }
                                 definitionContext.addServiceDefinition(swagger);
                             }
                        } catch (OcpException | IOException e) {
                            e.printStackTrace();
                            System.err.println("Exception Occurred :: " + e);
                        }
                    }

                }
             }
        }else{
            System.out.println("It is already Loading . Please try again later");
        }


    }

    public boolean isLoadRequired() {
        if(!isLoading.get() && (definitionContext.getServiceDescriptionMap()== null || definitionContext.getServiceDescriptionMap().size() <=0)){
            return  true;
        }
        return false;
    }
}
