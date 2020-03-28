package com.seven.forum.entity.zyl;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "post_info", type = "_doc")
public class PostInfoEntity {

    @Id
    private Long postId;
    @Field(type = FieldType.Long)
    private Long postBarId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String postTitle;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String postContent;
    @Field(type = FieldType.Long)
    private Long userId;
    @Field(type = FieldType.Integer)
    private Integer topPost;
    @Field(type = FieldType.Integer)
    private Integer wonderfulPost;
    @Field(type = FieldType.Integer)
    private Integer audit;
    @Field(type = FieldType.Long)
    private Long visitCount;
    @Field(type = FieldType.Integer)
    private Integer postStatus;
    @Field(type = FieldType.Date)
    private Date createTime;
    private Integer replyCount;
    private String userName;

}
