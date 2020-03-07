package com.seven.forum.config;

import com.seven.forum.entity.zyl.PostBarInfoEntity;
import com.seven.forum.entity.zyl.PostInfoEntity;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.time.Duration;

@Configuration
public class ESConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
        //使用HttpHeaders设置相关的请求头信息
        //HttpHeaders defaultHeaders = new HttpHeaders();
        ClientConfiguration configuration =  ClientConfiguration.builder()
                .connectedTo("127.0.0.1:9200")
                .withConnectTimeout(Duration.ofSeconds(5))
                .withSocketTimeout(Duration.ofSeconds(3))
                //.withDefaultHeaders(defaultHeaders)
                .build();
        return RestClients.create(configuration).rest();
    }
}