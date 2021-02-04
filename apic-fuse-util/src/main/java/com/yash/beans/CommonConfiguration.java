package com.yash.beans;

import com.yash.cache.LocalCache;
import com.yash.exceptions.OcpException;
import com.yash.provider.ocp.json.routelist.RouteListSuccessResponse;
import com.yash.service.ModuleRouteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class CommonConfiguration {

    @Autowired
    ModuleRouteInfoService moduleRouteInfoService;

    @Autowired
    RestOcpClient client;

    @Autowired
    LocalCache cache;

    @Async
    public void loadSwagger(String ocpToken) throws OcpException {
        if(moduleRouteInfoService.isLoadRequired()) {
            cache.setAuthorization(ocpToken);
            cache.setNamespace("intg-int04");
            ResponseEntity<RouteListSuccessResponse> response = client.getRouteList();
            moduleRouteInfoService.transformSwagger("test", response.getBody());
            System.out.println("Completed ......");
        }
    }

}
