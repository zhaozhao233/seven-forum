package com.seven.forum;

import com.seven.forum.dao.hzw.NfMessageDao;
import com.seven.forum.entity.hzw.NfUserEntity;
import com.seven.forum.entity.hzw.chatting.BetweenUserChatting;
import com.seven.forum.entity.hzw.message.MessageTypeEntity;
import com.seven.forum.entity.hzw.message.NfMessageEntity;
import com.seven.forum.entity.hzw.message.UserAllMessageEntity;
import com.seven.forum.entity.hzw.message.UserMessageTypeEntity;
import com.seven.forum.service.hzw.ChattingService;
import com.seven.forum.service.hzw.NfMessageService;
import com.seven.forum.service.hzw.NfUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@MapperScan("com.seven.forum.dao")
public class SpringBootApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(SpringBootApp.class, args);

//        NfMessageService service1 = run.getBean(NfMessageService.class);
//        ChattingService service2 = run.getBean(ChattingService.class);

    }
}
