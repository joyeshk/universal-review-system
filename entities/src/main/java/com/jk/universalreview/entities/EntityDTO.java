package com.jk.universalreview.entities;

public class EntityDTO {
    private String entityName;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public EntityDTO(String entityName) {
        this.entityName = entityName;
    }

    public EntityDTO() {
    }
}
