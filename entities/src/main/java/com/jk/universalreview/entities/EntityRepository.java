package com.jk.universalreview.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntityRepository extends JpaRepository<Entity,String> {
    @Query(nativeQuery = true, value = "SELECT * FROM entity e where e.entity_name like CONCAT('%',:entity_name,'%')")
    List<Entity> findEntitiesByName(@Param("entity_name") String entityName);
}
