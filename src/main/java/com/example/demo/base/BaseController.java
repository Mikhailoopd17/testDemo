package com.example.demo.base;

import com.example.demo.pojo.AEntry;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class BaseController<Dto extends AEntry, Params, R extends AEntry> {
    private BaseService<Dto, Params, R> baseService;

    public BaseController(BaseService<Dto, Params, R> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/list")
    public List<Dto> list() {
        return baseService.list();
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
