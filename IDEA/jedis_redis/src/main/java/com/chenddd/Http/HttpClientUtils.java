package com.chenddd.Http;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

/**
 * @author chenddd
 * @title: HttpClientUtils
 * @projectName jedis_redis
 * @description: TODO
 * @date 2022/3/258:57
 */
public class HttpClientUtils {
    private static final String ENCODING = "UTF-8";
    private static final Integer CONNECTION_TIMEOUT = 6000;
    private static final Integer SOCKET_TIMEOUT = 6000;

    /**
     *
     * @param params
     * @param httpMethod
     */
    private static void PacketHandler(Map<String, String> params, HttpRequestBase httpMethod){
        if (params != null){
            Set<Entry<String,String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet){
                httpMethod.setHeader(entry.getKey(),entry.getValue());
            }
        }
    }

    /**
     *
     * @param params
     * @param httpEntityEnclosingRequestBase
     * @throws UnsupportedEncodingException
     */
    public static void packageParams(Map<String, String> params,
                                     HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase) throws UnsupportedEncodingException {
        if (params != null){
            ArrayList<NameValuePair> nvps = new ArrayList<>();
            Set<Entry<String, String>> entrySet = params.entrySet();
            for (Entry<String, String> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            httpEntityEnclosingRequestBase.setEntity(new UrlEncodedFormEntity(nvps,ENCODING));
        }
    }

    /**
     *
     * @param httpResponse
     * @param httpClient
     * @param httpRequestBase
     * @return
     * @throws Exception
     */
    public static HttpClientResp getHttpClientResult(CloseableHttpResponse httpResponse,
                                                     CloseableHttpClient httpClient,HttpRequestBase httpRequestBase) throws Exception {
        httpClient.execute(httpRequestBase);
        if (httpResponse !=null && httpResponse.getStatusLine()!=null){
            String content = "";
            if (httpResponse.getEntity()!=null){
                content = EntityUtils.toString(httpResponse.getEntity(),ENCODING);
            }
            return new HttpClientResp(httpResponse.getStatusLine().getStatusCode(),content);
        }
        return new HttpClientResp(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    public static void release(CloseableHttpResponse httpResponse,CloseableHttpClient httpClient) throws IOException {
        if (httpResponse != null){
            httpResponse.close();
        }
        if (httpClient!=null){
            httpClient.close();
        }
    }

    /**
     *
     * @param url
     * @param headers
     * @param params
     * @return
     * @throws Exception
     */
    public static HttpClientResp doPost(String url,Map<String, String> headers,
                                        Map<String, String> params) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECTION_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPost.setConfig(requestConfig);
        PacketHandler(headers, httpPost);
        packageParams(params,httpPost);
        CloseableHttpResponse httpResponse = null;
        try {
            return getHttpClientResult(httpResponse, httpClient, httpPost);
        }finally {
            release(httpResponse,httpClient);
        }
    }
}
