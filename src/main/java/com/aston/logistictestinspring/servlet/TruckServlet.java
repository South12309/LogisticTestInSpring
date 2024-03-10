package com.aston.logistictestinspring.servlet;


import com.aston.logistictestinspring.service.TruckService;
import com.aston.logistictestinspring.servlet.dto.TruckDto;
import com.aston.logistictestinspring.servlet.mapper.TruckMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TruckServlet {
    private final TruckService service;
    private final TruckMapper mapper;

    public TruckServlet(TruckService service, TruckMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TruckDto> getAll() {
        return mapper.entityToDtoList(service.findAll());
    }
    @GetMapping
    public TruckDto getById(@RequestParam int id) {
        return mapper.entityToDto(service.findById(id));
    }
    @PostMapping
    public TruckDto save(@RequestBody TruckDto dto) {
        return mapper.entityToDto(service.save(mapper.dtoToEntity(dto)));
    }
    @DeleteMapping
    public void delete(@RequestParam int id) {
        service.delete(id);
    }
}
