package com.seven.forum.entity.zyl;

import lombok.Data;

import java.util.List;

@Data
public class PostBarPartitionEntity {

    private Long partitionId;
    private String partitionName;
    private Integer partitionStatus;
    private List<PartitionCatalogueEntity> partitionCatalogueEntities;

    @Override
    public String toString() {
        return "PostBarPartitionEntity{" +
                "partitionId=" + partitionId +
                ", partitionName='" + partitionName + '\'' +
                ", partitionStatus=" + partitionStatus +
                ", partitionCatalogueEntities=" + partitionCatalogueEntities +
                '}';
    }
}
