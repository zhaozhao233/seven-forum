package com.seven.forum.controller.lhj;

import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import com.seven.forum.service.lhj.UserDynamicService;
import com.seven.forum.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/dynamic")
public class UserDynamicController {
    @Autowired
    private UserDynamicService dynamicService;

    //显示我关注的人发的动态
    @RequestMapping("/followUserDynamic")
    public ResponseVO listDynamic(Integer pageNum,Integer pageSize,Integer userId){
        List<UserDynamicEntity> userDynamicEntities = dynamicService.listFollowUserDynamic(pageNum, pageSize, userId);
        ResponseVO vo = new ResponseVO();
        vo.setData(userDynamicEntities);
        return vo;
    }

    @RequestMapping("/listComment")
    //显示该动态下的所有评论
    public ResponseVO listComment(Integer pageNum,Integer pageSize,Integer dynamicId){
        List<UserCommentEntity> userCommentEntities = dynamicService.listCommentByDynamicId(pageNum,pageSize,dynamicId);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(userCommentEntities);
        return responseVO;
    }

    @RequestMapping("/commentDynamic")
    @ResponseBody
    //评论动态
    public String commentDynamic(Integer userId,Integer dynamicId,String commentContent){
        dynamicService.commentDynamic(userId,dynamicId,commentContent);
        return "comment done";
    }

    @RequestMapping("/replyComment")
    @ResponseBody
    public String replyComment(Integer userId,Integer dynamicId,String commentContent,Integer replyUserId){
        dynamicService.replyUser(userId,dynamicId,commentContent,replyUserId);
        return "reply done";
    }




}
