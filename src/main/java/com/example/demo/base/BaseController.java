package com.example.demo.base;

import com.example.demo.pojo.AEntry;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.PageParams;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<L, Dto extends AEntry, Params extends BaseParams, R extends AEntry> {
    private BaseService<L, Dto, Params, R> baseService;

    public BaseController(BaseService<L, Dto, Params, R> baseService) {
        this.baseService = baseService;
    }

    @PostMapping("/list")
    public Page<L> list(@RequestBody PageParams<Params> pageParams) {
        return baseService.list(pageParams);
    }

    @GetMapping("/{id}")
    public Dto getById(@PathVariable("id") Long id) {
        return baseService.getById(id);
    }

    @PostMapping
    public Dto create(@RequestBody Dto dto) {
       return baseService.create(dto);
    }

    @PutMapping
    public Dto update(@RequestBody Dto dto) {
        return baseService.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        baseService.delete(id);
    }


}
