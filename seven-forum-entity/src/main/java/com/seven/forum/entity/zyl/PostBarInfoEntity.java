package com.seven.forum.entity.zyl;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
public class PostBarInfoEntity {

    private Long postBarId;
    private Long catalogueId;
    private String postBarName;

    private String postBarExplain;
    private String postBarLogoUrl;
    private Long userId;
    private Long postCount;
    private Long userCount;
    private Date createTime;
    private Integer postBarStatus;

    @Override
    public String toString() {
        return "PostBarInfoEntity{" +
                "postBarId=" + postBarId +
                ", catalogueId=" + catalogueId +
                ", postBarName='" + postBarName + '\'' +
                ", postBarExplain='" + postBarExplain + '\'' +
                ", postBarLogoUrl='" + postBarLogoUrl + '\'' +
                ", userId=" + userId +
                ", postCount=" + postCount +
                ", userCount=" + userCount +
                ", createTime=" + createTime +
                ", postBarStatus=" + postBarStatus +
                '}';
    }
}
