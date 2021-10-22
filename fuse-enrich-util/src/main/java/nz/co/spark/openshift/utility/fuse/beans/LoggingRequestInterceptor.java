package nz.co.spark.openshift.utility.fuse.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {

    final static Logger log = LoggerFactory.getLogger(LoggingRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        log.info("===========================request begin================================================");
        if (!(request.getURI() != null && request.getURI().getRawPath().contains("authorize")) || log.isTraceEnabled()) {
            log.debug("URI         : {}", request.getURI());
            log.debug("Method      : {}", request.getMethod());
            log.debug("Headers     : {}", request.getHeaders() );
            log.debug("Request body: {}", new String(body, "UTF-8"));
        }else{
            log.debug("Request body: { Sanitized : auth request}");
        }
        log.info("==========================request end================================================");
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = null;

        log.info("============================response begin==========================================");
        log.debug("Status code  : {}", response.getStatusCode());
        log.debug("Status text  : {}", response.getStatusText());
        log.debug("Headers      : {}", response.getHeaders());
        if (log.isTraceEnabled()) {
            inputStringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
            String line = bufferedReader.readLine();
            while (line != null) {
                inputStringBuilder.append(line);
                inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
            log.trace("Response body: {}", inputStringBuilder.toString());
        }

        log.info("=======================response end=================================================");
    }

}