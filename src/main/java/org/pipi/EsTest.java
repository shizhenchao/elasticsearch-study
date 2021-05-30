package org.pipi;

import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.util.HashMap;
import java.util.Map;

public class EsTest {
    public static void main(String[] args) throws Exception {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200)));
        // 创建Index
//        CreateIndexResponse response = restHighLevelClient.indices().create(new CreateIndexRequest("index1"), RequestOptions.DEFAULT);
//        System.out.println(response.isAcknowledged());

        // 查询Index
//        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(new GetIndexRequest("index1"), RequestOptions.DEFAULT);
//        System.out.println(getIndexResponse.getMappings());
//        System.out.println(getIndexResponse.getSettings());
//        System.out.println(getIndexResponse.getAliases());

//        // 删除Index
//        AcknowledgedResponse acknowledgedResponse = restHighLevelClient.indices().delete(new DeleteIndexRequest("user"), RequestOptions.DEFAULT);
//        System.out.println(acknowledgedResponse.isAcknowledged());

        // 创建Doc
//        IndexRequest indexRequest = new IndexRequest("user");
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "张三");
//        map.put("age", 20);
//        map.put("tel", 1000);
//        indexRequest.source(map);
//        IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
//        System.out.println(indexResponse.getResult());
        // 批量添加
        IndexRequest indexRequest = new IndexRequest("user");
        Map<String, Object> map = new HashMap<>();
        map.put("name", "李四");
        map.put("age", 20);
        map.put("tel", 1000);
        indexRequest.source(map);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(indexRequest);
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.getTook());

        restHighLevelClient.close();

    }
}
