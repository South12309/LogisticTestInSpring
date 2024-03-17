package com.aston.logistictestingspring.servlet;

import com.aston.logistictestingspring.service.DriverService;
import com.aston.logistictestingspring.servlet.dto.DriverDto;
import com.aston.logistictestingspring.servlet.mapper.DriverMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/drivers")
public class DriverServlet {
    private final DriverService service;
    private final DriverMapper mapper;

    public DriverServlet(DriverService service, DriverMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    protected DriverDto getById(@PathVariable("id") int id) {
        return mapper.entityToDto(service.findById(id));
    }
    @GetMapping
    protected List<DriverDto> getAll() {
        return mapper.entityToDtoList(service.findAll());
    }

    @PostMapping
    protected DriverDto save(@RequestBody DriverDto driverDto) {
        return mapper.entityToDto(service.save(mapper.dtoToEntity(driverDto)));

    }

    @DeleteMapping
    protected void doDelete(@RequestParam("id") int id) {
        service.delete(id);
    }
}
