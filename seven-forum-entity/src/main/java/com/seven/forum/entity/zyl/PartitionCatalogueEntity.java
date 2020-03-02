package com.seven.forum.entity.zyl;

import lombok.Data;

@Data

public class PartitionCatalogueEntity {

    private Long catalogueId;
    private Long partitionId;
    private String catalogueName;
    private Integer catalogueStatus;

    @Override
    public String toString() {
        return "PartitionCatalogueEntity{" +
                "catalogueId=" + catalogueId +
                ", partitionId=" + partitionId +
                ", catalogueName='" + catalogueName + '\'' +
                ", catalogueStatus=" + catalogueStatus +
                '}';
    }
}
