package com.chenddd.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;

import java.io.IOException;

/**
 * Author: chenddd
 * Date: 2022/11/30 20:45
 * FileName: ES_DocCreate
 * Description:
 */
public class ES_DocDelete {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1001");
        DeleteResponse delete = client.delete(request, RequestOptions.DEFAULT);
        RestStatus status = delete.status();
        System.out.println(status);
        System.out.println(delete.getResult());
        System.out.println(delete.toString());


        client.close();
    }
}
