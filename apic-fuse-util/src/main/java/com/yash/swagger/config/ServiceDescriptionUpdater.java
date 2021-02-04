//package com.yash.swagger.config;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.yash.beans.RestOcpClient;
//import com.yash.cache.LocalCache;
//import com.yash.exceptions.OcpException;
//import com.yash.provider.ocp.json.routelist.Item;
//import com.yash.provider.ocp.json.routelist.RouteListSuccessResponse;
//import io.swagger.models.Swagger;
//import io.swagger.parser.Swagger20Parser;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.client.RestClientException;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Optional;
//
//
//@Component
//public class ServiceDescriptionUpdater {
//
//	private static final Logger logger = LoggerFactory.getLogger(ServiceDescriptionUpdater.class);
//
//	private static final String DEFAULT_SWAGGER_URL="/v2/api-docs";
//	private static final String KEY_SWAGGER_URL="swagger_url";
//
//	@Autowired
//	LocalCache cache;
//
//	@Autowired
//	RestOcpClient client;
//
//	@Autowired
//	private ServiceDefinitionsContext definitionContext;
//
//	@Scheduled(fixedDelayString= "${swagger.config.refreshrate}")
//	public void refreshSwaggerConfigurations(){
//		logger.debug("Starting Service Definition Context refresh");
//		try {
//			cache.setAuthorization("1D5SQfuurifBaxNKxRtC0HrP9F4TiqeFPr4eYoMbSoI");
//			cache.setNamespace("intg-int04");
//
//			ResponseEntity<RouteListSuccessResponse> response = client.getRouteList();
//			getSwaggerFromURL(response.getBody());
//
//		} catch (OcpException e) {
//			e.printStackTrace();
//		}
//	}
//	private void getSwaggerFromURL(RouteListSuccessResponse responseList){
//		{
//			List<String> fileNameList = new LinkedList<>();
//			if(responseList != null && !CollectionUtils.isEmpty(responseList.getItems())){
//				for(Item item : responseList.getItems()){
//					if(item.getMetadata().getName().contains("rest")) {
//						try {
//							String host = item.getSpec().getHost();
//							String jsonData = client.getSwaggerDefinitionForAPI(item.getMetadata().getName(), "http://"+host);
//							if(jsonData != null){
////								String content = getJSON(item.getMetadata().getName(), jsonData.get());
//								definitionContext.addServiceDefinition(item.getMetadata().getName(), jsonData,"http://"+host);
//								System.out.println(item.getMetadata().getName()+"Json " + jsonData);
//							}else{
//								logger.error("Skipping service id : {} Error : Could not get Swagger definition from API ",item.getMetadata().getName());
//							}
//
//							logger.info("Service Definition Context Refreshed at :  {}", LocalDate.now());
//						} catch (Exception e) {
//							e.printStackTrace();
//							System.err.println("Exception Occurred :: " + e);
//						}
//					}
//					System.out.println("Loading Swagger");
//
//				}
//				System.out.println("Loaded Swagger");
//
//			}
//
//
//		}
//	}
//
//
//
//
//	public String getJSON(String serviceId, Object jsonData){
//		try {
//			return new ObjectMapper().writeValueAsString(jsonData);
//		} catch (JsonProcessingException e) {
//			logger.error("Error : {} ", e.getMessage());
//			return "";
//		}
//	}
//}
