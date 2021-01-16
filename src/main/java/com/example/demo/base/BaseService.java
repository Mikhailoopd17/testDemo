package com.example.demo.base;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;
import com.example.demo.util.BaseMapping;
import com.example.demo.util.MappingService;

import java.time.LocalDateTime;

public abstract class BaseService<List, Dto extends BaseEntity, Request, Params extends BaseParams, Entity extends BaseEntity> {
    private BaseMapping mappingService;
    private BaseListDao<Entity, Params> baseListDao;
    private BaseDao<Entity> baseDao;
    private Class<Dto> dtoClass;
    private Class<Request> requestClass;
    private Class<Entity> entityClass;
    private Class<List> listClass;

    public BaseService(BaseDao<Entity> baseDao,
                       Class<Dto> dtoClass,
                       Class<Entity> entityClass,
                       MappingService mappingService,
                       BaseListDao<Entity, Params> baseListDao,
                       Class<Request> requestClass, Class<List> listClass) {
        this.baseDao = baseDao;
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
        this.mappingService = mappingService;
        this.baseListDao = baseListDao;
        this.requestClass = requestClass;
        this.listClass = listClass;
    }

    public Dto getById(Long id) {
        return mappingService.map(baseDao.getById(id), dtoClass);
    }

    public Dto create(Request request) {
        Entity entity = mappingService.map(request, entityClass);
        entity.setCreatedAt(LocalDateTime.now());
        return mappingService.map(baseDao.create(entity), dtoClass);
    }

    public Dto update(Dto dto) {
        Entity entity = mappingService.map(dto, entityClass);
        entity.setUpdatedAt(LocalDateTime.now());
        return mappingService.map(baseDao.update(entity), dtoClass);
    }

    public void delete(Long id) {
        Entity entity = baseDao.getById(id);
        entity.setDeletedAt(LocalDateTime.now());
        entity.setDeleted(Boolean.TRUE);
        baseDao.update(entity);
    }

    public Page<List> list(PageParams<Params> pageParams) {
        Page<Entity> page = baseListDao.list(pageParams);
        java.util.List<List> list = mappingService.mapList(page.getList(), listClass);
        return new Page<>(list, page.getTotal());
    }
}
