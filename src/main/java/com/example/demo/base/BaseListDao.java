package com.example.demo.base;

import com.example.demo.pojo.AEntry;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;

public interface BaseListDao<Entity extends AEntry, Params>  {
    Page<Entity> list(PageParams<Params> pageParams);
}
