package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.PostInfoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostInfoService {

    List<PostInfoEntity> findByPostContent(String content);
}
