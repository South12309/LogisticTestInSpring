package com.aston.logistictestinspring.servlet.mapper;

import com.aston.logistictestinspring.model.TruckEntity;
import com.aston.logistictestinspring.servlet.dto.TruckDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TruckMapper {
    TruckEntity dtoToEntity(TruckDto dto);
    TruckDto entityToDto(TruckEntity entity);
    List<TruckEntity> dtoToEntityList(List<TruckDto> dtos);
    List<TruckDto> entityToDtoList(List<TruckDto> entities);
}
