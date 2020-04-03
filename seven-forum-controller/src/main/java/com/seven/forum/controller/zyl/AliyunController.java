package com.seven.forum.controller.zyl;

import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.seven.forum.util.AliyunOssUtils;
import com.seven.forum.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/api")
public class AliyunController {
    @Autowired
    private AliyunOssUtils aliyunOssUtils;

    @GetMapping("/sts")
    public ResponseVO sts() {
        AssumeRoleResponse ossSts = aliyunOssUtils.getOssSts();
        if (null == ossSts) {
            return new ResponseVO(501, "获取sts令牌失败");
        } else {
            return new ResponseVO(200, "success", ossSts);
        }
    }
}
