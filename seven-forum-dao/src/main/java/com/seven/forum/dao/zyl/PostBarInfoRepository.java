package com.seven.forum.dao.zyl;

import com.seven.forum.entity.zyl.PostBarInfoEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PostBarInfoRepository extends ElasticsearchRepository<PostBarInfoEntity, Long> {

    List<PostBarInfoEntity> queryByPostBarNameContains(String postBarName);


}
