package com.jk.universalreview.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {
    Logger log = LoggerFactory.getLogger(EntityService.class);
    @Autowired
    EntityRepository entityRepository;

    protected List<Entity> getAllEntities(){
        return entityRepository.findAll();
    }

    protected Entity getEntityById(String entityId){
        Entity entity = entityRepository.findById(entityId).orElse(null);
        return entity;
    }

    protected List<Entity> findEntitiesByName(EntityDTO entityDTO){
        log.info("findEntitiesByName:"+entityDTO.getEntityName());
        return entityRepository.findEntitiesByName(entityDTO.getEntityName());
    }

    protected void addEntity(Entity entity){
        entityRepository.save(entity);
    }

    protected void updateEntity(Entity entity){
        entityRepository.save(entity);
    }
}
