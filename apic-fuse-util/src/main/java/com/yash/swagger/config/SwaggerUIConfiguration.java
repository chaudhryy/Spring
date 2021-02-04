//package com.yash.swagger.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.context.annotation.Primary;
//import org.springframework.web.client.RestTemplate;
//import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
//import springfox.documentation.swagger.web.SwaggerResource;
//import springfox.documentation.swagger.web.SwaggerResourcesProvider;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Configuration
//public class SwaggerUIConfiguration {
//
//	@Autowired
//	private ServiceDefinitionsContext definitionContext;
//
//
//    @Primary
//    @Bean
//    @Lazy
//    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider, RestTemplate temp) {
//        return () -> {
//            List<SwaggerResource> swaggerResourceList = defaultResourcesProvider.get();
////            List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
//            swaggerResourceList.clear();
//            swaggerResourceList.addAll(definitionContext.getSwaggerDefinitions());
//            return swaggerResourceList;
//        };
//    }
//}
