package com.seven.forum.dao.zyl;

import com.seven.forum.entity.zyl.PostBarInfoEntity;

import java.util.List;
import java.util.Set;

public interface PostBarInfoDAO {

    List<Integer> listPopularPostBarId();

    List<PostBarInfoEntity> listPopularPostBar(Set<Integer> postBarId);

    List<PostBarInfoEntity> listPostBarByPartitionId(Long partitionId);

    List<PostBarInfoEntity> listPostBarByCatalogueId(Long catalogueId);

    List<PostBarInfoEntity> listPostBarById(Long postBarId);

    Integer ifExist(String postBarName);

    void updateExplainById(String postBarExplain, Long postBarId);

    void updateLogo(String logoUrl, Long postBarId);

    void updateCatalogue(Long catalogueId, Long postBarId);

    void updateUserId(Long userId, Long postBarId);

    void addPostCount(Long postBarId);

    void addUserCount(Long postBarId);

    void reducePostCount(Long postBarId);

    void reduceUserCount(Long postBarId);

    void reducePostBar(Long postBarId);

    void insertPostBarInfo(PostBarInfoEntity postBarInfoEntity);
}
