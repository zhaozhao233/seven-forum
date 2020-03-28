package com.seven.forum.controller.zyl;

import com.seven.forum.entity.zyl.PostBarInfoEntity;
import com.seven.forum.service.zyl.SearchService;
import com.seven.forum.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping("/searchs/postBars")
    public ResponseVO getPostBarsByKey(String postBarNameKey) {
        List<PostBarInfoEntity> postBarInfoEntities = searchService.queryPostBarNameByKey(postBarNameKey);
        return new ResponseVO(200, "success", postBarInfoEntities);
    }

//    @RequestMapping("/searchs/postInfos")
//    public ResponseVO getPostInfoByKey(String postKey) {
//        return new ResponseVO(200, )
//    }
}
