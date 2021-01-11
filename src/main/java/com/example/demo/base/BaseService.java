package com.example.demo.base;

import com.example.demo.pojo.AEntry;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;
import com.example.demo.util.BaseMapping;
import com.example.demo.util.MappingService;

import java.time.LocalDateTime;

public abstract class BaseService<List, Dto extends AEntry, Params, Entity extends AEntry> {
    private BaseMapping mappingService;
    private BaseListDao<Entity, Params> baseListDao;
    private BaseDao<Entity> baseDao;
    private Class<Dto> dtoClass;
    private Class<Entity> entityClass;
    private Class<List> listClass;

    public BaseService(BaseDao<Entity> baseDao,
                       Class<Dto> dtoClass,
                       Class<Entity> entityClass,
                       MappingService mappingService,
                       BaseListDao<Entity, Params> baseListDao,
                       Class<List> listClass) {
        this.baseDao = baseDao;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
        this.mappingService = mappingService;
        this.baseListDao = baseListDao;
        this.listClass = listClass;
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

    public Page<List> list(PageParams<Params> pageParams) {
        Page<Entity> page = baseListDao.list(pageParams);
        java.util.List<List> list = mappingService.mapList(page.getList(), listClass);
        return new Page<>(list, page.getTotal());
    }
}
