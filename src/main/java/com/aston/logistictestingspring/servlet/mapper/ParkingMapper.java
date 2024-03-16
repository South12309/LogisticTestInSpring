package com.aston.logistictestingspring.servlet.mapper;

import com.aston.logistictestingspring.model.ParkingEntity;
import com.aston.logistictestingspring.servlet.dto.ParkingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TruckMapperWithoutParkingAndDrivers.class)
public interface ParkingMapper {
    ParkingEntity dtoToEntity(ParkingDto dto);
    ParkingDto entityToDto(ParkingEntity entity);
    List<ParkingEntity> dtoToEntityList(List<ParkingDto> dtos);
    List<ParkingDto> entityToDtoList(List<ParkingEntity> entities);

}
