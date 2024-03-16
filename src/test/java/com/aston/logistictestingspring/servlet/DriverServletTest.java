package com.aston.logistictestingspring.servlet;

import com.aston.logistictestingspring.model.DriverEntity;
import com.aston.logistictestingspring.service.DriverService;
import com.aston.logistictestingspring.service.impl.DriverServiceImpl;
import com.aston.logistictestingspring.servlet.dto.DriverDto;
import com.aston.logistictestingspring.servlet.mapper.DriverMapper;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;
import static org.mockito.Mockito.*;


class DriverServletTest {
    private static DriverServlet servlet;
    @Mock
    private static DriverService service;
    private static DriverMapper mapper;
    private static DriverEntity driverEntity1;
    private static DriverEntity driverEntity2;
    private static List<DriverEntity> driverEntities;
    private static DriverDto driverDto1;

    @BeforeAll
    static void beforeAll() {
        servlet = new DriverServlet(service, mapper);

        driverEntity1 = new DriverEntity();
        driverEntity1.setSurname("Surname1");
        driverEntity1.setName("Name1");
        driverEntity1.setPatronymic("Patronymic1");

        driverEntity2 = new DriverEntity();
        driverEntity1.setSurname("Surname2");
        driverEntity1.setName("Name2");
        driverEntity1.setPatronymic("Patronymic2");

        driverEntities = List.of(driverEntity1, driverEntity2);

        driverDto1 = new DriverDto();
        driverDto1.setSurname("Surname1");
        driverDto1.setName("Name1");
        driverDto1.setPatronymic("Patronymic1");

    }

    @Test
    void getById() {
        when(service.findById(1)).thenReturn(driverEntity1);
        DriverDto driverDto = servlet.getById(1);
        Assertions.assertEquals(driverDto.getId(), driverEntity1.getId());
        Assertions.assertEquals(driverDto.getSurname(), driverEntity1.getSurname());
        Assertions.assertEquals(driverDto.getName(), driverEntity1.getName());
        Mockito.verify(mapper, times(1)).entityToDto(driverEntity1);
        Mockito.verify(service, times(1)).findById(1);
    }

    @Test
    void getAll() {
        when(service.findAll()).thenReturn(driverEntities);
        List<DriverDto> driverDtos = servlet.getAll();
        Mockito.verify(service, times(1)).findAll();
        Mockito.verify(mapper, times(1)).entityToDtoList(driverEntities);
        Assertions.assertEquals(2, driverDtos.size());
        Assertions.assertEquals(driverDtos.get(0).getId(), driverEntity1.getId());
        Assertions.assertEquals(driverDtos.get(1), driverEntity2.getId());

    }

    @Test
    void save() {
        when(service.save(any(DriverEntity.class))).thenReturn(driverEntity1);
        DriverDto saved = servlet.save(driverDto1);
        Mockito.verify(service, times(1)).save(any(DriverEntity.class));
        Mockito.verify(mapper, times(1)).dtoToEntity(any(DriverDto.class));
        Mockito.verify(mapper, times(1)).entityToDto(any(DriverEntity.class));
        Assertions.assertEquals(saved.getId(),driverEntity1.getId());
    }

    @Test
    void doDelete() {
        Mockito.verify(service, times(1)).delete(anyInt());
    }
}