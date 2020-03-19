package com.seven.forum.controller.lhj;

import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import com.seven.forum.service.lhj.UserDynamicService;
import com.seven.forum.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String commentDynamic(Integer userId, Integer dynamicId, String commentContent,@RequestParam(defaultValue = "1") Integer commentStatus){
        dynamicService.commentDynamicWithAddCommentCount(userId,dynamicId,commentContent,commentStatus);
        return "comment done";
    }

    @RequestMapping("/replyComment")
    @ResponseBody
    //回复评论
    public String replyComment(Integer userId,Integer dynamicId,String commentContent,Integer replyUserId,@RequestParam(defaultValue = "1")Integer commentStatus){
       dynamicService.replyUserWithAddCommentCount(userId,dynamicId,commentContent,replyUserId,commentStatus);
        return "reply done";
    }

    @RequestMapping("/releaseDynamic")
    @ResponseBody
    //发布动态
    public String releaseDynamic(Integer userId,String dynamicContent){
        dynamicService.releaseDynamic(userId,dynamicContent);
        return "release done";
    }

    @RequestMapping("/likeDynamic")
    @ResponseBody
    public String likeDynamic(Integer likeObjId, Integer userId, @RequestParam(defaultValue = "1") Integer likeStatus, Integer dynamicId){
        dynamicService.likeDynamicAndAddLikeCount(likeObjId,userId,likeStatus,dynamicId);
        return "like dynamic done";
    }


    @RequestMapping("/likeComment")
    @ResponseBody
    public String likeComment(@RequestParam(defaultValue = "1") Integer likeType, Integer likeObjId, Integer userId, @RequestParam(defaultValue = "1") Integer likeStatus, Integer commentId){
        dynamicService.likeCommentAndAddLikeCount(likeType,likeObjId,userId,likeStatus,commentId);
        return "like comment done";
    }






}
