package com.seven.forum;

import com.seven.forum.entity.zyl.PostBarPartitionEntity;
import com.seven.forum.service.zyl.PostBarPartitionService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.List;

@MapperScan("com.seven.forum.dao.zyl")
@SpringBootApplication
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }


}
