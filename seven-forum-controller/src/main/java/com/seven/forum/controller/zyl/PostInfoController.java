package com.seven.forum.controller.zyl;

import com.seven.forum.entity.zyl.PostInfoEntity;
import com.seven.forum.entity.zyl.ReplyInfoEntity;
import com.seven.forum.entity.zyl.ReplyPostInfoEntity;
import com.seven.forum.service.zyl.PostInfoService;
import com.seven.forum.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api/postInfos")
public class PostInfoController {

    @Autowired
    private PostInfoService postInfoService;

    /**
     * 查询帖子所属的贴吧信息
     * @param postId 帖子id
     * @return
     */
    @GetMapping("/postBars/postBarInfos")
    public ResponseVO getPostBarByPostId(Long postId) {
        log.info("查询了帖子id[" + postId + "]的所属贴吧的信息");
        return new ResponseVO(200, "success", postInfoService.getPostBarByPostId(postId));
    }

    /**
     * 分页查询帖子的回帖
     * @param postId 帖子id
     * @param pageNum 页码
     * @param pageSize 页容量
     * @return
     */
    @GetMapping("/postBars/posts")
    public ResponseVO listPostsAndReplies(Long postId, Integer pageNum, Integer pageSize) {
        log.info("查询了帖子id[" + postId + "]下的所有回帖");
        // 回帖总数，用于分页
        Long totalPost = postInfoService.countReplyPosts(postId);
        List<ReplyPostInfoEntity> replyPostInfoEntities = postInfoService.listPostsAndCountReply(postId, pageNum, pageSize);
        return new ResponseVO(200, totalPost + "", replyPostInfoEntities);
    }


    /**
     * 查询某个帖子下的所有回复
     *
     * @param postId 帖子id
     * @return
     */
    @GetMapping("/replies/byPostId")
    public ResponseVO listRepliesByPostId(Long postId) {
        log.info("查询了帖子id[" + postId + "]下的所有回复");
        return new ResponseVO(200, "success", postInfoService.listRepliesByPostId(postId));
    }

    /**
     * 点击只看楼主后，查询所有楼主的回帖
     *
     * @param postId 帖子id
     * @return
     */
    @GetMapping("/postReplies/landlords")
    public ResponseVO listLandlordReplyPost(Long postId) {
        log.info("在帖子编号[" + postId + "]点击了只看楼主功能");
        return new ResponseVO(200, "success", postInfoService.listJustLandlordPostsAndCountReply(postId));
    }

    /**
     * 添加回复
     * @param replyInfoEntity 回复信息：主要有：用户id，被回复用户id，被回复的回帖id，回复内容
     * @return
     */
    @PostMapping("/replies")
    public ResponseVO insertReply(@RequestBody ReplyInfoEntity replyInfoEntity) {
        log.info("用户id[" + replyInfoEntity.getUserId() + "]在回帖id" + replyInfoEntity.getReplyPostId() + "]回复了用户id[" +replyInfoEntity.getReplyUserId() + "]");
        postInfoService.insertReply(replyInfoEntity);
        return new ResponseVO(200, "success");
    }

    /**
     * 回帖
     * @param replyPostInfoEntity 回帖信息，主要有：用户id，帖子id，回帖内容
     * @return
     */
    @PostMapping("/replyPosts")
    public ResponseVO insertReplyPost(@RequestBody ReplyPostInfoEntity replyPostInfoEntity) {
        log.info("用户id[" + replyPostInfoEntity.getUserId() + "]回复了id[" + replyPostInfoEntity.getPostId() +"]的帖子");
        postInfoService.insertReplyPost(replyPostInfoEntity);
        return new ResponseVO(200, "success");
    }

    /**
     *
     * @param postInfoEntity
     * @return postId：用于转页面到帖子界面
     */
    @PostMapping("/posts")
    public ResponseVO insertPost(@RequestBody PostInfoEntity postInfoEntity) {
        log.info("用户id[" + postInfoEntity.getUserId() + "]在贴吧id[" + postInfoEntity.getPostBarId() + "]发帖");
        Long postId = postInfoService.insertPost(postInfoEntity);
        return new ResponseVO(200, postId.toString());
    }
}
