package com.yash.beans;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Configuration
public class RestHttpConfiguration {



    @Bean
    @Primary
    public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException {


        return new RestTemplate(getRequestFactory());
    }

    private HttpComponentsClientHttpRequestFactory getRequestFactory() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[] {};
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
                // Do nothing because exhibit client trusted
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
                // Do nothing because exhibit server trusted
            }
        } };


        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, trustAllCerts, null);
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                new String[] { "TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }, null, new HostnameVerifier() {
            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        });

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).setRedirectStrategy(new CustomRedirectStrategy())
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        requestFactory.setConnectionRequestTimeout(100000);

//        new RestTemplate(new SimpleClientHttpRequestFactory() {
//            protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
//                super.prepareConnection(connection, httpMethod);
//                connection.setInstanceFollowRedirects(false);
//            } 	});
        return requestFactory;
    }


}
