package com.aston.logistictestingspring.servlet.mapper;

import com.aston.logistictestingspring.model.ParkingEntity;
import com.aston.logistictestingspring.servlet.dto.ParkingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ParkingMapperWithoutTrucks {
    @Mapping(target = "trucks", ignore = true)
    ParkingDto entityToDtoWithoutTrucks(ParkingEntity entity);
    @Mapping(target = "trucks", ignore = true)
    List<ParkingDto> entityToDtoListWithoutTrucks(List<ParkingEntity> entities);
}
