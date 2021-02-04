package co.nz.spark.utility.BackFillProcessor.routes;

import co.nz.spark.utility.BackFillProcessor.model.BackFillJsonModel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class BackFillProcessor extends RouteBuilder {

    @Override
    public void configure() throws Exception {
     getContext().setStreamCaching(true);
//     getContext().setUseMDCLogging(true);



     from("direct:routeBackFillProcessor")
	.log("test")

     .end();

     restConfiguration()
			 .component("undertow")
			 .scheme("{{common.http_protocol}}")
			 .bindingMode(RestBindingMode.json)
			 .skipBindingOnErrorCode(true)
			 .enableCORS(true)
			 .dataFormatProperty("prettyPrint", "true")
			 .apiContextPath("/")
			 .apiContextRouteId("swagger")
			 .host("{{common.http_host}}")
			 .port("{{common.http_port}}")
			 .contextPath("{{context.path}}");

     			rest()
				.consumes(MediaType.APPLICATION_JSON_VALUE)
				.produces(MediaType.APPLICATION_JSON_VALUE)
					.post("/backfill/prepare/config")
						.description("Prepare Back Fill Config")
						.type(BackFillJsonModel.class)
					.responseMessage()
						.code(HttpStatus.OK.value())

					.endResponseMessage()
					.responseMessage()
						.code(HttpStatus.NO_CONTENT.value())
							.message(HttpStatus.NO_CONTENT.name())
					.endResponseMessage()
					.responseMessage()
						.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.endResponseMessage()

				.responseMessage()
						.code(HttpStatus.BAD_REQUEST.value())
				.endResponseMessage()

				.responseMessage()
						.code(HttpStatus.GATEWAY_TIMEOUT.value())

				.endResponseMessage()

				.route()
					.routeId("route-rest")
						.log("BackFillProcessor POST:/backfill/prepare/config ,Body= ${body}")
								.to("direct:routeBackFillProcessor")
                            .log("Response ,Body= ${body} ")
                .endRest();
    }
}
