package com.seven.forum.controller.zyl;

import com.seven.forum.entity.zyl.PostBarInfoEntity;
import com.seven.forum.service.zyl.PostInfoService;
import com.seven.forum.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/postInfos")
public class PostInfoController {

    @Autowired
    private PostInfoService postInfoService;

    @GetMapping("/postBars/postBarInfos")
    public ResponseVO getPostBarByPostId(Long postId) {
        return new ResponseVO(200, "success", postInfoService.getPostBarByPostId(postId));
    }

    @GetMapping("/postBars/posts")
    public ResponseVO listPostsAndReplies(Long postId) {
        return new ResponseVO(200, "success", postInfoService.listPostsAndCountReply(postId));
    }


    @GetMapping("/replies/byPostId")
    public ResponseVO listRepliesByPostId(Long postId) {
        return new ResponseVO(200, "success", postInfoService.listRepliesByPostId(postId));
    }
}
