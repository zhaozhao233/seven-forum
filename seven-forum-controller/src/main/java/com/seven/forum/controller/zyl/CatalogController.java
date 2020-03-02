package com.seven.forum.controller.zyl;

import com.seven.forum.entity.zyl.PartitionCatalogueEntity;
import com.seven.forum.service.zyl.PostBarPartitionService;
import com.seven.forum.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@CrossOrigin
@Slf4j
public class CatalogController {
    @Autowired
    private PostBarPartitionService postBarPartitionService;

    @RequestMapping("/api/partitions")
    public ResponseVO listAllPartitionEntities() {
//        log.trace("------------------------------------------------ahu");
        ResponseVO<String> responseVO = new ResponseVO<>();
        responseVO.setData("123");
        return responseVO;
    }


}
