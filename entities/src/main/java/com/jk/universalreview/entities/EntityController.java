package com.jk.universalreview.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entities")
public class EntityController {
    @Autowired
    EntityService entityService;

    @PostMapping("/addEntity")
    public void addEntity(@RequestBody Entity entity){
        entityService.addEntity(entity);
    }

    @GetMapping("/list")
    public List<Entity> getAllEntities(){
        return entityService.getAllEntities();
    }

    @PutMapping("/update")
    public void updateEntity(Entity entity){
        entityService.updateEntity(entity);
    }

    @PostMapping("/findByName")
    public List<Entity> findEntitiesByName(@RequestBody EntityDTO entityDTO){
        return entityService.findEntitiesByName(entityDTO);
    }
}
