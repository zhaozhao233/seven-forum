package com.seven.forum.service.zyl;

import com.seven.forum.entity.zyl.PostBarInfoEntity;
import com.seven.forum.entity.zyl.PostInfoEntity;

import java.util.List;

public interface SearchService {

    List<PostBarInfoEntity> queryPostBarNameByKey(String postBarNameKey);

    List<PostInfoEntity> queryPostInfoByPostTitleKey(String titleKey);
}
