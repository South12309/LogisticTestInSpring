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

    @BeforeAll
    static void beforeAll() {
        service = mock(DriverServiceImpl.class);
        servlet = new DriverServlet(service, mapper);
    }

    @Test
    void getById() {
        DriverEntity driverEntity = new DriverEntity();
        driverEntity.setSurname("Surname1");
        driverEntity.setName("Name1");
        driverEntity.setPatronymic("Patronymic1");
        when(service.findById(1)).thenReturn(driverEntity);
        DriverDto driverDto = servlet.getById(1);
        Assertions.assertEquals(driverDto.getId(), driverEntity.getId());
        Assertions.assertEquals(driverDto.getSurname(), driverEntity.getSurname());
        Assertions.assertEquals(driverDto.getName(), driverEntity.getName());
        Mockito.verify(mapper, times(1)).entityToDto(driverEntity);
        Mockito.verify(service, times(1)).findById(1);
    }

    @Test
    void getAll() {
        DriverEntity driverEntity1 = new DriverEntity();
        driverEntity1.setSurname("Surname1");
        driverEntity1.setName("Name1");
        driverEntity1.setPatronymic("Patronymic1");

        DriverEntity driverEntity2 = new DriverEntity();
        driverEntity1.setSurname("Surname2");
        driverEntity1.setName("Name2");
        driverEntity1.setPatronymic("Patronymic2");

        List<DriverEntity> driverEntities = List.of(driverEntity1, driverEntity2);
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
        DriverEntity driverEntity1 = new DriverEntity();
        driverEntity1.setSurname("Surname1");
        driverEntity1.setName("Name1");
        driverEntity1.setPatronymic("Patronymic1");

        DriverDto driverDto1 = new DriverDto();
        driverDto1.setSurname("Surname1");
        driverDto1.setName("Name1");
        driverDto1.setPatronymic("Patronymic1");

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