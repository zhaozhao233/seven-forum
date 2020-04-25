package com.seven.forum.controller.zyl;

import com.seven.forum.service.zyl.PostBarInfoService;
import com.seven.forum.service.zyl.PostInfoService;
import com.seven.forum.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api")
public class PostBarController {
    @Autowired
    private PostBarInfoService postBarInfoService;

    @Autowired
    private PostInfoService postInfoService;

    @GetMapping("/populars/postBars")
    public ResponseVO getPopularPostBars() {
        log.trace("主页显示了8个热门贴吧");
        return new ResponseVO(200, "success", postBarInfoService.listEightPopularPostBars());
    }

    @GetMapping("/postBars/{postBarId}")
    public ResponseVO getPostBar(@PathVariable("postBarId")Long postBarId) {
        log.trace("用户搜索了id为" + postBarId + "的贴吧");
        return new ResponseVO(200, "success", postBarInfoService.getPostBarById(postBarId));
    }

    @GetMapping("/postBars/posts/{postBarId}/{pageNum}/{pageSize}")
    public ResponseVO listPosts(@PathVariable("postBarId")Long postBarId, @PathVariable("pageNum")Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        log.trace("显示贴吧id为" + postBarId + "的所有帖子");
        return new ResponseVO(200, postInfoService.countPostInfoByPostBarId(postBarId) + "", postInfoService.listAllPostInfos(postBarId, pageNum, pageSize));
    }

    @GetMapping("/postBars/posts/goods/{postBarId}/{pageNum}/{pageSize}")
    public ResponseVO listWonderfulPosts(@PathVariable("postBarId")Long postBarId, @PathVariable("pageNum")Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        log.trace("显示贴吧id为" + postBarId + "的所有帖子");
        return new ResponseVO(200, postInfoService.countWonderfulPostInfoByPostBarId(postBarId) + "", postInfoService.listAllWonderfulPost(postBarId, pageNum, pageSize));
    }

    @GetMapping("/postBars/catalogues")
    public ResponseVO getCatalogue(Long postBarId) {
        log.trace("查询贴吧id为[" + postBarId + "]的目录信息");
        return new ResponseVO(200, "success", postInfoService.getCatalogueByPostBarId(postBarId));
    }

    @GetMapping("/is/postBars")
    public ResponseVO isExistsPostBarByPostBarId(Long postBarId) {
        log.trace("查询贴吧id为[" + postBarId + "]贴吧是否存在");
        Integer isExists = postBarInfoService.isExistsPostBar(postBarId);
        return new ResponseVO(200, isExists + "");
    }
}
