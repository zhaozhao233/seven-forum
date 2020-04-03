package com.seven.forum.test;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.seven.forum.SpringBootApp;
import com.seven.forum.dao.zyl.PostBarInfoRepository;
//import com.seven.forum.dao.zyl.PostInfoRepository;
import com.seven.forum.entity.zyl.PostBarInfoEntity;
import com.seven.forum.entity.zyl.PostInfoEntity;
import com.seven.forum.service.zyl.SearchService;
import com.seven.forum.service.zyl.impl.SearchServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApp.class)
public class ElasticsearchTest {

    @Autowired
    private ElasticsearchRestTemplate template;

    @Autowired
    private SearchService searchService;

    @Test
    public void testCreatePostBar() {
        template.createIndex(PostBarInfoEntity.class);
    }

    @Test
    public void testCreatePostBarMapping() {
        template.putMapping(PostBarInfoEntity.class);
    }

    @Test
    public void testCreatePostInfo() {
        template.createIndex(PostInfoEntity.class);
    }

    @Test
    public void testCreatePostInfoMapping() {
        template.putMapping(PostInfoEntity.class);
    }

    @Test
    public void testQueryPostBar() {
        List<PostBarInfoEntity> postBarInfoEntities = searchService.queryPostBarNameByKey("生");
//        for (PostBarInfoEntity postBarInfoEntity : postBarInfoEntities) {
//            System.out.println(postBarInfoEntity);
//        }
        System.out.println(postBarInfoEntities);
    }

    @Test
    public void testQueryPostInfo() {
        // 结局，两遍
        List<PostInfoEntity> postInfoEntities = searchService.queryPostInfoByPostTitleKey("结局");
        System.out.println(postInfoEntities);
    }
//    private String endpoint;
//    @Test
//    public void testRegular() {
//        System.out.println(endpoint);
//    }

}
