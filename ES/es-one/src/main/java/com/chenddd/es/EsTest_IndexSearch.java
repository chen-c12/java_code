package com.chenddd.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.AliasMetadata;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Author: chenddd
 * Date: 2022/11/30 20:24
 * FileName: EsTest_IndexCreate
 * Description:
 */
public class EsTest_IndexSearch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));

        GetIndexResponse getIndexResponse = client.indices()
                .get(new GetIndexRequest("user"), RequestOptions.DEFAULT);

        Map<String, List<AliasMetadata>> aliases = getIndexResponse.getAliases();
        System.out.println(aliases);

        client.close();
    }
}
