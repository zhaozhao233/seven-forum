package com.seven.forum;

import com.seven.forum.entity.lhj.UserDynamicEntity;
import com.seven.forum.entity.zyl.PostBarPartitionEntity;
import com.seven.forum.service.lhj.UserDynamicService;
import com.seven.forum.service.zyl.PostBarPartitionService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
@MapperScan("com.seven.forum.dao")
public class SpringBootApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(SpringBootApp.class, args);
//        PostBarPartitionService bean = run.getBean(PostBarPartitionService.class, run);
//        List<PostBarPartitionEntity> postBarPartitionEntities = bean.listAllPartitionsAndCatalogues();
//        for (PostBarPartitionEntity postBarPartitionEntity : postBarPartitionEntities) {
//            System.out.println(postBarPartitionEntity);
//        }
//        UserDynamicService bean = run.getBean(UserDynamicService.class, run);
//        List<UserDynamicEntity> userDynamicEntities = bean.listFollowUserDynamic(1,2,123);
//        for (UserDynamicEntity userDynamicEntity : userDynamicEntities) {
//            System.out.println("userDynamicEntity = " + userDynamicEntity);
//        }
    }
}
