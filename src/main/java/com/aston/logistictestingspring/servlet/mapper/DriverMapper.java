package com.aston.logistictestingspring.servlet.mapper;

import com.aston.logistictestingspring.model.DriverEntity;
import com.aston.logistictestingspring.servlet.dto.DriverDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    DriverEntity dtoToEntity(DriverDto dto);
    DriverDto entityToDto(DriverEntity entity);
    List<DriverEntity> dtoToEntityList(List<DriverDto> dtos);
    List<DriverDto> entityToDtoList(List<DriverEntity> entities);
}
