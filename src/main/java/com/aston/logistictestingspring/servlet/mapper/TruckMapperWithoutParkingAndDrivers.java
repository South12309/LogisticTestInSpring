package com.aston.logistictestingspring.servlet.mapper;

import com.aston.logistictestingspring.model.TruckEntity;
import com.aston.logistictestingspring.servlet.dto.TruckDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TruckMapperWithoutParkingAndDrivers {
    @Mapping(target = "drivers", ignore = true)
    @Mapping(target = "parking", ignore = true)
    TruckDto entityToDtoWithoutDriversAndParking(TruckEntity entity);
    @Mapping(target = "drivers", ignore = true)
    @Mapping(target = "parking", ignore = true)
    List<TruckDto> entityToDtoListWithoutDriversAndParking(List<TruckEntity> entities);
}
