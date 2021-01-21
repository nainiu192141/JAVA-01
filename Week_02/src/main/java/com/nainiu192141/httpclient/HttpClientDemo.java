package com.nainiu192141.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by xfx on 2021/1/21 20:04
 */
public class HttpClientDemo {
    public static final String URL = "http://localhost:8803";

    public static void main(String[] args){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        RequestConfig requestConfig =  RequestConfig.custom()
                    .setSocketTimeout(60 * 1000)
                    .setConnectTimeout(60 * 1000).build();
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse responseBody = null;
        System.err.println("begin at " + System.currentTimeMillis());
        try {
            responseBody = httpClient.execute(httpGet);
            int status = responseBody.getStatusLine().getStatusCode();
            if (status < 200 || status >= 300) {
                System.out.println("请求失败,状态码："+status);
            }
            HttpEntity entity = responseBody.getEntity();
            String res =  entity != null ? EntityUtils.toString(entity) : null;
            System.out.println(res);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (responseBody != null) {
                    responseBody.close();
                }
                httpGet.releaseConnection();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
