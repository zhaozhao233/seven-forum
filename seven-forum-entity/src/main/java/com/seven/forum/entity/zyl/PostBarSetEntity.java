package com.seven.forum.entity.zyl;

import lombok.Data;

@Data
public class PostBarSetEntity {

  private Long postBarId;
  private Long auditReleasePost;

  @Override
  public String toString() {
    return "PostBarSetEntity{" +
            "postBarId=" + postBarId +
            ", auditReleasePost=" + auditReleasePost +
            '}';
  }
}
