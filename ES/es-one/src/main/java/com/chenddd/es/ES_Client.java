package com.chenddd.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * Author: chenddd
 * Date: 2022/11/29 21:07
 * FileName: ES_Client
 * Description:
 */
public class ES_Client {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        client.close();
    }
}
