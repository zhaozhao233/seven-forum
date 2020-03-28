package com.seven.forum.controller.zyl;

import com.seven.forum.service.zyl.PostBarInfoService;
import com.seven.forum.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api")
public class HomePageController {

    @Autowired
    private PostBarInfoService postBarInfoService;
    @RequestMapping("/home/popularPostBars")
    public ResponseVO popularPostBar() {
        log.debug("查询八个热门贴吧");
        return new ResponseVO(200, "success", postBarInfoService.listEightPopularPostBars());
    }
}
