package com.aston.logistictestingspring.servlet.mapper;

import com.aston.logistictestingspring.model.DriverEntity;
import com.aston.logistictestingspring.servlet.dto.DriverDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface DriverMapperWithoutTruck {
    @Mapping(target = "trucks", ignore = true)
    DriverDto entityToDtoWithoutTruks(DriverEntity entity);
    @Mapping(target = "trucks", ignore = true)
    List<DriverDto> entityToDtoListWithoutTruks(List<DriverEntity> entities);
}
