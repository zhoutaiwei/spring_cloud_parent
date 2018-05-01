package com.zuul.dynamic.filter.Fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 为zuul添加回退，当目标服务异常或超时时回退
 */
@Component
public class Hello_serverFallback implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        //表明为那个服务做回退
        return "hello-service";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                //回滚时的状态码
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                //数字类型的状态码，本例返回其实就是200
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                //返回状态文本，就是“OK”
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                //响应体
                return new ByteArrayInputStream("该服务暂时不可用，请稍后再试！".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {

                //headers设定
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mediaType = new MediaType("application", "json", Charset.forName("utf-8"));
                httpHeaders.setContentType(mediaType);

                return httpHeaders;
            }
        };
    }
}
