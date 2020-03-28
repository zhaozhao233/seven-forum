package com.seven.forum.entity.zyl;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "post_bar_info", type = "_doc")
public class PostBarInfoEntity {

    @Id
    @Field(type = FieldType.Long)
    private Long postBarId;
    @Field(type = FieldType.Long)
    private Long catalogueId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String postBarName;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String postBarExplain;
    @Field(type = FieldType.Text)
    private String postBarLogoUrl;
    @Field(type = FieldType.Long)
    private Long userId;
    @Field(type = FieldType.Long)
    private Long postCount;
    @Field(type = FieldType.Long)
    private Long userCount;
    @Field(type = FieldType.Date)
    private Date createTime;
    @Field(type = FieldType.Integer)
    private Integer postBarStatus;

}
