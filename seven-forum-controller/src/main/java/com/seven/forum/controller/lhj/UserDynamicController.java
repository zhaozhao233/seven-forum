package com.seven.forum.controller.lhj;

import com.seven.forum.entity.lhj.UserCommentEntity;
import com.seven.forum.entity.lhj.UserDynamicEntity;
import com.seven.forum.service.lhj.UserDynamicService;
import com.seven.forum.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/dynamic")
public class UserDynamicController {
    @Autowired
    private UserDynamicService dynamicService;
    @RequestMapping("/followUserDynamic")//我关注的人发的动态
    public ResponseVO listDynamic(Integer pageNum,Integer pageSize,Integer userId){
        List<UserDynamicEntity> userDynamicEntities = dynamicService.listFollowUserDynamic(pageNum, pageSize, userId);
        ResponseVO vo = new ResponseVO();
        vo.setData(userDynamicEntities);
        return vo;
    }

    @RequestMapping("/commentByDynamicId")
    public ResponseVO listComment(Integer dynamicId){//该动态下的所有评论
        List<UserCommentEntity> userCommentEntities = dynamicService.listCommentByDynamicId(dynamicId);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(userCommentEntities);
        return responseVO;
    }


}
