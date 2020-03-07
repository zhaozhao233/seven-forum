package com.seven.forum.controller.zyl;

import com.seven.forum.entity.zyl.PostBarPartitionEntity;
import com.seven.forum.service.zyl.PostBarPartitionService;
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
public class CatalogController {
    @Autowired
    private PostBarPartitionService postBarPartitionService;

    @RequestMapping("/api/partitions")
    public ResponseVO listAllPartitionEntities() {
        log.trace("列出所有分区和目录");
        List<PostBarPartitionEntity> postBarPartitionEntities = postBarPartitionService.listAllPartitionsAndCatalogues();
        return new ResponseVO(200, "success", postBarPartitionEntities);
    }


}
