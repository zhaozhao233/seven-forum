package com.seven.forum.controller.hzw;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.util.StringUtil;
import com.seven.forum.entity.hzw.message.NfMessageEntity;
import com.seven.forum.entity.hzw.message.UserAllMessageEntity;
import com.seven.forum.entity.hzw.message.UserMessageTypeEntity;
import com.seven.forum.service.hzw.NfMessageService;
import com.seven.forum.vo.ResponseVO;
import com.seven.forum.vo.ResponseVOBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
//@CrossOrigin("http://localhost:8848")
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private NfMessageService nfMessageService;

    // 获取新消息数量
    @RequestMapping("/new/count")
    @ResponseBody
    public ResponseVO<Integer> newMessageCount(@RequestParam("userId") Integer userId) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("没有找到用户ID："+userId).withData("").build();

        if (userId != null) {
            int i = nfMessageService.countUnreadNfMessageByUserId(userId);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("获取用户ID：" + userId + "的未读消息数量").withData(i).build();
        }

        return responseVO;
    }

    // 获取用户所有消息
    @RequestMapping("/all")
    @ResponseBody
    public ResponseVO<UserAllMessageEntity> getUserAllMessage(@RequestParam("userId")Integer userId) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("没有找到用户ID："+userId).withData("").build();

        if (userId != null) {
            UserAllMessageEntity userAllMessageByUserId = nfMessageService.getUserAllMessageByUserId(userId);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("获取用户ID："+userId+"所有消息").withData(userAllMessageByUserId).build();
        }

        return responseVO;
    }


    // 获取某一类型的消息
    @RequestMapping("/type")
    @ResponseBody
    public ResponseVO<UserMessageTypeEntity> getUserMessageByMessageTypeId(@RequestParam("messageTypeId") Integer messageTypeId, HttpServletRequest request) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("").withData("").build();

        if (messageTypeId != null) {
            UserMessageTypeEntity userMessageTypeByUserIdType = nfMessageService.getUserMessageTypeByUserIdType(1, messageTypeId);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("获取用户ID：所有类型为："+messageTypeId+"的消息").withData(userMessageTypeByUserIdType).build();
        }

        return responseVO;
    }


    // 已读所有消息
    @RequestMapping("/read/all")
    @ResponseBody
    public ResponseVO<String> readAllMessage(@RequestParam("userId") Integer userId) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("没有找到用户ID："+userId).withData("").build();

        if (userId != null) {
            int i = nfMessageService.updateReadNfMessageByUserId(userId);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("已读用户ID："+userId+"所有消息").withData("").build();
        }

        return responseVO;
    }

    // 已读某一类型消息
    @RequestMapping("/read/type")
    @ResponseBody
    public ResponseVO<String> readTypeMessage(@RequestParam("userId") Integer userId, @RequestParam("typeId") Integer typeId) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("没有找到用户ID："+userId).withData("").build();

        if (userId != null) {
            int i = nfMessageService.updateReadNfMessageByUserIdType(userId,typeId);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("已读用户ID："+userId+"类型："+typeId+"所有消息").withData("").build();
        }

        return responseVO;

    }

    // 已读指定消息
    @RequestMapping("/read/messageid")
    @ResponseBody
    public ResponseVO<String> readMessage(@RequestParam("userId") Integer userId, @RequestParam("messageId") String messageId) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("没有找到用户ID："+userId).withData("").build();

        if (userId != null) {
            List<Integer> messageList = new ArrayList<>();
            JSONArray obj = JSON.parseArray(messageId);
            if (obj.size() > 0) {
                for (int i = 0; i < obj.size(); i++) {
                    Integer integer = Integer.valueOf(String.valueOf(obj.get(i)));
                    messageList.add(integer);
                }
            } else {
                messageList.add(Integer.valueOf(messageId));
            }
            int i = nfMessageService.updateReadNfMessageListByUserIdMessageId(userId,messageList);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("已读用户ID："+userId+"类型："+messageId+"所有消息").withData("").build();
        }

        return responseVO;
    }


    // 添加一条消息
    @RequestMapping("/add")
    @ResponseBody
    public ResponseVO addMessage(@Param("userId")Integer userId,@Param("messageTypeId")Integer messageTypeId,@Param("authorId")Integer authorId,@Param("messageContent")String messageContent) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("没有找到用户ID："+userId).withData("").build();

        if (userId != null && authorId != null) {
            NfMessageEntity messageEntity = new NfMessageEntity();
            messageEntity.setUserId(userId);
            messageEntity.setMessageTypeId(messageTypeId);
            messageEntity.setAuthorId(authorId);
            messageEntity.setMessageContent(messageContent);
            messageEntity.setMessageRead(0);
            messageEntity.setMessageTime(new Timestamp(new Date().getTime()));
            int i = nfMessageService.insertMessage(messageEntity);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("用户ID："+authorId+"给用户ID："+userId+"发送消息，内容为："+messageContent).withData("").build();
        }

        return responseVO;

    }

}
