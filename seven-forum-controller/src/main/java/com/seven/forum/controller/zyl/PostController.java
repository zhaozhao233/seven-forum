//package com.seven.forum.controller.zyl;
//
//import com.seven.forum.dao.zyl.PostInfoDAO;
//import com.seven.forum.service.zyl.PostInfoService;
//import com.seven.forum.service.zyl.ReplyPostInfoService;
//import com.seven.forum.vo.ResponseVO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin
//@Slf4j
//@RequestMapping("/api")
//public class PostController {
//    @Autowired
//    private PostInfoService postInfoService;
//    @Autowired
//    private ReplyPostInfoService replyPostInfoService;
//
//    /**
//     * 查询某个post的信息
//     * @param postId post的id
//     * @return
//     */
//    @RequestMapping("/posts/{postId}")
//    public ResponseVO getPostById(@PathVariable("postId")Long postId) {
//        return new ResponseVO(200, "success", postInfoService.getPostInfoById(postId));
//    }
//
//    /**
//     * 查询某个post的所有回帖信息
//     * @param postId 帖子id
//     * @return
//     */
//    @RequestMapping("/posts/{postId}/replyPosts")
//    public ResponseVO listReplyPosts(@PathVariable("postId")Long postId) {
//        return new ResponseVO(200, "success", postInfoService.replyPostInfos(postId));
//    }
//
//    /**
//     * 某个帖子下有多少个回帖
//     * @param postId 帖子id
//     * @return
//     */
//    @RequestMapping("/posts/count")
//    public ResponseVO countReplyPosts(Long postId) {
//        return new ResponseVO(200, "success", postInfoService.countPostReplies(postId));
//    }
//
//    /**
//     * 某个回帖下有多少个回复
//     * @param replyPostId 回帖id
//     * @return
//     */
//    @RequestMapping("/replies/count")
//    public ResponseVO countReplies(Long replyPostId) {
//        return new ResponseVO(200, "success", replyPostInfoService.countReplies(replyPostId));
//    }
//
//    /**
//     * 某个回帖下的所有回复
//     * @param replyPostId 回帖id
//     * @return
//     */
//    @RequestMapping("/replyPosts/replies")
//    public ResponseVO listReplies(Long replyPostId) {
//        return new ResponseVO(200, "success", replyPostInfoService.listRepliesByReplyPostId(replyPostId));
//    }
//
//}
