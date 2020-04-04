package com.seven.forum.entity.zyl;

import lombok.Data;

import java.util.Date;

@Data
public class CollectGroup {

  private Long collectGroupId;
  private String groupName;
  private Long userId;
  private Date createTime;
  private Integer status;

  /**
   * 收藏夹下的收藏总数
   */
  private Integer totalNum;
}
