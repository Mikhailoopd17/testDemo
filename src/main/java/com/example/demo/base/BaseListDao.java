package com.example.demo.base;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;

public interface BaseListDao<Entity extends BaseEntity, Params extends BaseParams>  {
    Page<Entity> list(PageParams<Params> pageParams);
}
