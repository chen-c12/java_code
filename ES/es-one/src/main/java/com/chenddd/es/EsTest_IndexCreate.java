package com.chenddd.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;


import java.io.IOException;

/**
 * Author: chenddd
 * Date: 2022/11/30 20:24
 * FileName: EsTest_IndexCreate
 * Description:
 */
public class EsTest_IndexCreate {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        CreateIndexResponse indexResponse = client.indices()
                .create(new CreateIndexRequest("user"), RequestOptions.DEFAULT);
        boolean acknowledged = indexResponse.isAcknowledged();
        System.out.println(acknowledged);

        client.close();
    }
}
