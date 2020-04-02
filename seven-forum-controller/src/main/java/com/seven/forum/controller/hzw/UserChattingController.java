package com.seven.forum.controller.hzw;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.seven.forum.entity.hzw.chatting.BetweenUserChatting;
import com.seven.forum.entity.hzw.chatting.ChattingListEntity;
import com.seven.forum.entity.hzw.chatting.UserChattingEntity;
import com.seven.forum.service.hzw.ChattingService;
import com.seven.forum.vo.ResponseVO;
import com.seven.forum.vo.ResponseVOBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/chatting")
public class UserChattingController {

    @Autowired
    private ChattingService chattingService;

    /**
     * 查询用户之间的聊条记录
     * @param sendUserId    发送用户
     * @param receiveUserId 接受用户
     * @return
     */
    @RequestMapping("/betweenuser")
    @ResponseBody
    public ResponseVO<BetweenUserChatting> listChattingByBetweenUser(@RequestParam("sendUserId") Integer sendUserId, @RequestParam("receiveUserId") Integer receiveUserId) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("读取用户ID："+sendUserId+"与用户ID："+receiveUserId+"的聊天记录失败").withData("").build();

        if (sendUserId != null && receiveUserId != null) {
            BetweenUserChatting betweenUserChatting = chattingService.listChattingByBetweenUser(sendUserId, receiveUserId);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("获取用户ID："+sendUserId+"与用户ID："+receiveUserId+"的聊天记录").withData(betweenUserChatting).build();
        }

        return responseVO;
    }

    @RequestMapping("/chattinglist")
    @ResponseBody
    public ResponseVO<ChattingListEntity> listChattingSolo(@RequestParam("sendUserId") Integer sendUserId) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("找不到用户ID："+sendUserId).withData("").build();

        if (sendUserId != null) {
            ChattingListEntity chattingListEntity = chattingService.listChattingByUserId(sendUserId);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("获取用户ID："+sendUserId+"正在聊天的列表").withData(chattingListEntity).build();
        }

        return responseVO;
    }

    /**
     * 添加一条聊天记录
     * @param sendUserId 发送用户
     * @param receiveUserId 接受用户
     * @param chattingContent 聊天内容
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseVO insertChatting(@RequestParam("sendUserId") Integer sendUserId, @RequestParam("receiveUserId") Integer receiveUserId, @RequestParam("chattingContent") String chattingContent) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("插入用户ID："+sendUserId+"与用户ID："+receiveUserId+"的聊天记录失败").withData("").build();

        if (sendUserId != null && receiveUserId != null && chattingContent != null) {
            UserChattingEntity userChatting = new UserChattingEntity();
            userChatting.setUserId(sendUserId);
            userChatting.setChattingUserId(receiveUserId);
            userChatting.setChattingContent(chattingContent);
            userChatting.setChattingTime(new Timestamp(new Date().getTime()));
            userChatting.setChattingStatus(1);
            System.out.println("===========================================================");
            System.out.println("userChatting = " + userChatting);
            int i = chattingService.insertChatting(userChatting);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("插入用户ID："+sendUserId+"与用户ID："+receiveUserId+"的聊天记录").withData(i).build();
        }

        return responseVO;
    }

    /**
     * 添加多条聊天记录
     * @param sendUserId 发送用户
     * @param receiveUserId 接受用户们
     * @param chattingContent 聊天内容
     * @return
     */
    @RequestMapping("/add/list")
    @ResponseBody
    public ResponseVO insertChattingList(@RequestParam("sendUserId") Integer sendUserId,@RequestParam("receiveUserId") String receiveUserId, @RequestParam("chattingContent") String chattingContent) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("插入用户ID："+sendUserId+"与用户ID："+receiveUserId+"的聊天记录失败").withData("").build();

        if (sendUserId != null && receiveUserId != null && chattingContent != null) {
            List<Integer> receiveUserIdList = new ArrayList<>();
            JSONArray objects = JSON.parseArray(receiveUserId);
            if (objects.size() > 0) {
                for (int i = 0; i < objects.size(); i++) {
                    Integer integer = new Integer((String)objects.get(i));
                    receiveUserIdList.add(integer);
                }
            }
            UserChattingEntity userChatting = new UserChattingEntity();
            userChatting.setUserId(sendUserId);
//            userChatting.setChattingUserId();
            userChatting.setChattingContent(chattingContent);
            userChatting.setChattingTime(new Timestamp(new Date().getTime()));
            userChatting.setChattingStatus(1);
            int i = chattingService.insertChattingList(receiveUserIdList,userChatting);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(200).withMessage("插入用户ID："+sendUserId+"与用户ID："+receiveUserId+"的聊天记录").withData(i).build();
        }

        return responseVO;
    }

    /**
     * 修改一条聊天记录状态
     * @param chattingId 聊天记录ID
     * @param status 聊天记录状态
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResponseVO updateChatting(@RequestParam("chattingId") Integer chattingId, @RequestParam("status") Integer status) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("修改聊天记录ID："+chattingId+"失败").withData("").build();

        if (chattingId != null && status != null) {
            int i = chattingService.updateChatting(chattingId, status);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("修改聊天记录ID："+chattingId+"状态为："+status).withData(i).build();
        }

        return responseVO;
    }


    /**
     * 修改多条聊天记录状态
     * @param chattingId 聊天记录ID
     * @param status 状态
     * @return
     */
    @RequestMapping("/update/list")
    @ResponseBody
    public ResponseVO updateChattingList(@RequestParam("chattingId") String chattingId, @RequestParam("status") Integer status) {
        ResponseVO responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("修改聊天记录ID："+chattingId+"失败").withData("").build();

        if (chattingId != null && status != null) {
            List<Integer> chattingIdList = new ArrayList<>();
            JSONArray objects = JSON.parseArray(chattingId);
            if (objects.size() > 0) {
                for (int i = 0; i < objects.size(); i++) {
                    Integer integer = new Integer((String)objects.get(i));
                    chattingIdList.add(integer);
                }
            }
            int i = chattingService.updateChattingList(chattingIdList, status);
            responseVO = ResponseVOBuilder.aResponseVO().withCode(405).withMessage("修改聊天记录ID："+chattingId+"状态为："+status).withData(i).build();
        }

        return responseVO;
    }
}
