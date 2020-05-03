package com.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Component
public class ProducerFallback implements FallbackProvider {
    @Override
    public String getRoute() { // 指定要处理的service
        return "server-producer";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return clientHttpResponse();
    }

    private ClientHttpResponse clientHttpResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
            @Override
            public InputStream getBody() {
                return new ByteArrayInputStream("The service is unavailable.".getBytes());
            }
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.OK;
            }
            @Override
            public int getRawStatusCode() {
                return 200;
            }
            @Override
            public String getStatusText() {
                return "ok";
            }
            @Override
            public void close() {

            }
        };
    }
}
