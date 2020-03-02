package com.seven.forum.entity.zyl;


public class PostBarImpowerEntity {

    private Long postBarId;
    private Long userId;
    private Integer allowTopPost;
    private Integer allowWonderfulPost;
    private Integer allowClearPost;

    @Override
    public String toString() {
        return "PostBarImpowerEntity{" +
                "postBarId=" + postBarId +
                ", userId=" + userId +
                ", allowTopPost=" + allowTopPost +
                ", allowWonderfulPost=" + allowWonderfulPost +
                ", allowClearPost=" + allowClearPost +
                '}';
    }
}
