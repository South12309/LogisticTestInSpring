package com.aston.logistictestingspring.servlet.mapper;

import com.aston.logistictestingspring.model.TruckEntity;
import com.aston.logistictestingspring.servlet.dto.TruckDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DriverMapperWithoutTruck.class, ParkingMapperWithoutTrucks.class})
public interface TruckMapper {
    TruckEntity dtoToEntity(TruckDto dto);
    TruckDto entityToDto(TruckEntity entity);
    List<TruckEntity> dtoToEntityList(List<TruckDto> dtos);
    List<TruckDto> entityToDtoList(List<TruckEntity> entities);
}
