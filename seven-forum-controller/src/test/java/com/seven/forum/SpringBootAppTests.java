package com.seven.forum;

import com.seven.forum.entity.zyl.PostInfoEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import static org.junit.Assert.*;
@SpringBootTest
public class SpringBootAppTests {

    @Autowired
    private ElasticsearchRestTemplate template;

    @Test
    public void test1() {
        template.createIndex(PostInfoEntity.class);
    }

    @Test
    public void test2() {
        template.putMapping(PostInfoEntity.class);
    }
}