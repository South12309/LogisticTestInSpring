package com.aston.logistictestinspring.servlet;


import com.aston.logistictestinspring.model.ParkingEntity;
import com.aston.logistictestinspring.service.ParkingService;
import com.aston.logistictestinspring.servlet.dto.ParkingDto;
import com.aston.logistictestinspring.servlet.mapper.ParkingMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkings")
public class ParkingServlet {

    private final ParkingService service;
    private final ParkingMapper mapper;

    public ParkingServlet(ParkingService service, ParkingMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @GetMapping
    public List<ParkingDto> getAll() {
        return mapper.entityToDtoList(service.findAll());
    }
    @GetMapping
    public ParkingDto getById(@RequestParam int id) {
        return mapper.entityToDto(service.findById(id));
    }
    @PostMapping
    public ParkingDto save(@RequestBody ParkingDto dto) {
        return mapper.entityToDto(service.save(mapper.dtoToEntity(dto)));
    }
    @DeleteMapping
    public void delete(@RequestParam int id) {
        service.delete(id);
    }
}
