package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.PostBarInfoEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostBarInfoService {

    List<PostBarInfoEntity> listEightPopularPostBar();
}
