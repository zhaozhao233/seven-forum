package com.seven.forum.entity.zyl;

import lombok.Data;

@Data
public class PartitionCatalogueEntity {
    private Long catalogueId;
    private Long partitionId;
    private String catalogueName;
    private String catalogueExplain;
    private Integer catalogueStatus;

}
