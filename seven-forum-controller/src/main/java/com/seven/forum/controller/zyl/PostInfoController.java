package com.seven.forum.controller.zyl;

import com.seven.forum.entity.zyl.*;
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

    @PutMapping("/visitCounts")
    public ResponseVO updateVisitCount(Long postId) {
        log.trace("帖子id[" + postId + "]访问数+1");
        postInfoService.updateVisitCount(postId);
        return new ResponseVO(200, "success");
    }

    @GetMapping("/populars/postInfos")
    public ResponseVO listPopularPostInfos() {
        return new ResponseVO(200, "success", postInfoService.listEightPopularPostInfo());
    }
    /**
     * 查询帖子所属的贴吧信息
     *
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
     *
     * @param postId   帖子id
     * @param pageNum  页码
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
     *
     * @param replyInfoEntity 回复信息：主要有：用户id，被回复用户id，被回复的回帖id，回复内容
     * @return
     */
    @PostMapping("/replies")
    public ResponseVO insertReply(@RequestBody ReplyInfoEntity replyInfoEntity) {
        log.info("用户id[" + replyInfoEntity.getUserId() + "]在回帖id" + replyInfoEntity.getReplyPostId() + "]回复了用户id[" + replyInfoEntity.getReplyUserId() + "]");
        postInfoService.insertReply(replyInfoEntity);
        return new ResponseVO(200, "success");
    }

    /**
     * 回帖
     *
     * @param replyPostInfoEntity 回帖信息，主要有：用户id，帖子id，回帖内容
     * @return
     */
    @PostMapping("/replyPosts")
    public ResponseVO insertReplyPost(@RequestBody ReplyPostInfoEntity replyPostInfoEntity) {
        log.info("用户id[" + replyPostInfoEntity.getUserId() + "]回复了id[" + replyPostInfoEntity.getPostId() + "]的帖子");
        postInfoService.insertReplyPost(replyPostInfoEntity);
        return new ResponseVO(200, "success");
    }

    /**
     * @param postInfoEntity
     * @return postId：用于转页面到帖子界面
     */
    @PostMapping("/posts")
    public ResponseVO insertPost(@RequestBody PostInfoEntity postInfoEntity) {
        log.info("用户id[" + postInfoEntity.getUserId() + "]在贴吧id[" + postInfoEntity.getPostBarId() + "]发帖");
        Long postId = postInfoService.insertPost(postInfoEntity);
        return new ResponseVO(200, postId.toString());
    }

    @GetMapping("/postInfos")
    public ResponseVO getPostTitleAndPostUserIdByPostId(Long postId) {
        log.info("查询了贴吧id[" + postId + "]的标题和作者id");
        return new ResponseVO(200, "success", postInfoService.getPostInfoById(postId));
    }

    /**
     * 是否收藏了该帖子
     *
     * @param userId 用户id
     * @param postId 帖子id
     * @return
     */
    @GetMapping("/is/collections")
    public ResponseVO isCollection(Long userId, Long postId) {
        Integer isCollect = postInfoService.isCollectPost(userId, postId);
        return new ResponseVO(200, isCollect + "");
    }

    /**
     * 在帖子界面取消收藏
     *
     * @param userId
     * @param postId
     * @return
     */
    @DeleteMapping("/postInfos/collections")
    public ResponseVO cancelCollectPost(Long userId, Long postId) {
        postInfoService.deleteCollectionInPostInfo(userId, postId);
        return new ResponseVO(200, "success");
    }

    /**
     * 在收藏夹去取消收藏
     *
     * @param collectId 收藏id
     * @return
     */
    @DeleteMapping("/favorites/collections")
    public ResponseVO deleteCollectPost(Long collectId) {
        postInfoService.deleteCollectionInCollections(collectId);
        return new ResponseVO(200, "success");
    }

    /**
     * 列出所有收藏夹
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/collections")
    public ResponseVO listAllCollections(Long userId) {
        return new ResponseVO(200, "success", postInfoService.listAllCollections(userId));
    }

    /**
     * 是否关注贴吧
     *
     * @param userId    用户id
     * @param postBarId 贴吧id
     * @return
     */
    @GetMapping("/is/postBars")
    public ResponseVO isFollowPostBar(Long userId, Long postBarId) {
        Integer isFollowPostBar = postInfoService.isFollowPostBar(userId, postBarId);
        return new ResponseVO(200, isFollowPostBar + "");
    }

    /**
     * 关注贴吧
     *
     * @param userId    用户id
     * @param postBarId 贴吧id
     * @return
     */
    @PostMapping("/postBars")
    public ResponseVO followPostBar(Long userId, Long postBarId) {
        postInfoService.insertFollowPostBar(userId, postBarId);
        return new ResponseVO(200, "success");
    }

    /**
     * 收藏帖子
     *
     * @param userCollect 收藏信息
     * @return 收藏id，后面可用于在收藏夹中取消收藏
     */
    @PostMapping("/collections/postInfos")
    public ResponseVO collectPost(@RequestBody UserCollect userCollect) {
        Long collectId = postInfoService.insertCollectPost(userCollect);
        return new ResponseVO(200, collectId.toString());
    }

    /**
     * 创建收藏夹
     *
     * @param collectGroup 收藏夹信息
     * @return
     */
    @PostMapping("/collections")
    public ResponseVO createFavorites(@RequestBody CollectGroup collectGroup) {
        postInfoService.insertFavorites(collectGroup);
        return new ResponseVO(200, "success");
    }

    /**
     * 删除收藏夹
     *
     * @param collectGroupId 收藏夹id
     * @return
     */
    @DeleteMapping("/collections")
    public ResponseVO deleteFavorites(Long collectGroupId) {
        postInfoService.deleteFavorites(collectGroupId);
        return new ResponseVO(200, "success");
    }

    /**
     * 取消关注贴吧
     *
     * @param userId    用户id
     * @param postBarId 贴吧id
     * @return
     */
    @DeleteMapping("/follows/postBars")
    public ResponseVO deleteFollowPostBar(Long userId, Long postBarId) {
        postInfoService.deleteFollowPostBar(userId, postBarId);
        return new ResponseVO(200, "success");
    }

    @PutMapping("/replies")
    public ResponseVO updateReplyStatusByReplyId(Long replyId) {
        postInfoService.updateReplyStatusByReplyId(replyId);
        return new ResponseVO(200, "success");
    }

    @PutMapping("/replyPosts")
    public ResponseVO updateReplyPostStatusByReplyPostId(Long replyPostId) {
        postInfoService.updateReplyPostStatusByReplyPostId(replyPostId);
        return new ResponseVO(200, "success");
    }

    @GetMapping("/is/exists")
    public ResponseVO isExistsPost(Long postId) {
        Integer isExists = postInfoService.isExistsPost(postId);
        return new ResponseVO(200, isExists + "");
    }
}
