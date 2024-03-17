package com.aston.logistictestingspring.servlet;


import com.aston.logistictestingspring.service.TruckService;
import com.aston.logistictestingspring.servlet.dto.TruckDto;
import com.aston.logistictestingspring.servlet.mapper.TruckMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/trucks")
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
    @GetMapping("/{id}")
    public TruckDto getById(@PathVariable("id") int id) {
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
