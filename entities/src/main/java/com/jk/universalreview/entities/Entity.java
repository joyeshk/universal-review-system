package com.jk.universalreview.entities;

import jakarta.persistence.*;

import java.util.Objects;

@jakarta.persistence.Entity
@Table(name = "entity")
public class Entity {
    @Column(name = "entity_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String entityId;
    @Column(name = "entity_name")
    private String entityName;
    @Column(name = "entity_rating")
    private Double entityRating;

    //getter, setter, toString, hashCode, noArg constructor, all args constructor

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Double getEntityRating() {
        return entityRating;
    }

    public void setEntityRating(Double entityRating) {
        this.entityRating = entityRating;
    }

    public Entity() {
    }

    public Entity(String entityId, String entityName, Double entityRating) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.entityRating = entityRating;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "entityId='" + entityId + '\'' +
                ", entityName='" + entityName + '\'' +
                ", entityRating=" + entityRating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (!entityId.equals(entity.entityId)) return false;
        if (!Objects.equals(entityName, entity.entityName)) return false;
        return Objects.equals(entityRating, entity.entityRating);
    }

    @Override
    public int hashCode() {
        int result = entityId.hashCode();
        result = 31 * result + (entityName != null ? entityName.hashCode() : 0);
        result = 31 * result + (entityRating != null ? entityRating.hashCode() : 0);
        return result;
    }
}
