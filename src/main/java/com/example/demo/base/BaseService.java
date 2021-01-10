package com.example.demo.base;

import com.example.demo.pojo.AEntry;
import com.example.demo.util.BaseMapping;
import com.example.demo.util.MappingService;

import java.time.LocalDateTime;
import java.util.List;

public abstract class BaseService<Dto extends AEntry, Params, Entity extends AEntry> {
    private BaseMapping mappingService;
    private BaseDao<Entity> baseDao;
    private Class<Dto> dtoClass;
    private Class<Entity> entityClass;

    public BaseService(BaseDao<Entity> baseDao, Class<Dto> dtoClass, Class<Entity> entityClass, MappingService mappingService) {
        this.baseDao = baseDao;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
        this.mappingService = mappingService;
    }

    public Dto getById(Long id) {
        return mappingService.map(baseDao.getById(id), dtoClass);
    }

    public Dto create(Dto dto) {
        dto.setCreated_at(LocalDateTime.now());
        Entity entity = baseDao.create(mappingService.map(dto, entityClass));
        return mappingService.map(entity, dtoClass);
    }

    public Dto update(Dto dto) {
        Entity entity = mappingService.map(dto, entityClass);
        entity.setUpdated_at(LocalDateTime.now());
        return mappingService.map(baseDao.update(entity), dtoClass);
    }

    public void delete(Long id) {
        Entity entity = baseDao.getById(id);
        entity.setDeleted_at(LocalDateTime.now());
        baseDao.update(entity);
    }

    public List<Dto> list() {
        List<Entity> entities = baseDao.list();
        return mappingService.mapList(entities, dtoClass);
    }
}
