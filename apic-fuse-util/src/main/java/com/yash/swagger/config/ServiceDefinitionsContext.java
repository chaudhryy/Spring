package com.yash.swagger.config;

import io.swagger.models.Swagger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Component
@Scope(scopeName= ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ServiceDefinitionsContext {

//	private final List<Swagger> serviceDescriptions;
	private final ConcurrentHashMap<String,Swagger> serviceDescriptionMap;

	private ServiceDefinitionsContext(){
//		 serviceDescriptions = new LinkedList<>();
		 serviceDescriptionMap = new ConcurrentHashMap<>();
	 }

	 public void addServiceDefinition(Swagger swagger){
         String serviceId = swagger.getInfo().getTitle().replaceAll(" ","_");
//		 serviceDescriptions.add(swagger);
		 serviceDescriptionMap.put(serviceId,swagger);

	 }

	 public Swagger getSwaggerDefinition(String serviceName){
		 return this.serviceDescriptionMap.get(serviceName);
	 }

    public ConcurrentHashMap<String, Swagger> getServiceDescriptionMap() {
        return serviceDescriptionMap;
    }

    //	 public List<Swagger> getSwaggerDefinitions(){
//			return  serviceDescriptions;
//		 }
}
