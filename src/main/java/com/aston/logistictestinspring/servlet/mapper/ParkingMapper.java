package com.aston.logistictestinspring.servlet.mapper;

import com.aston.logistictestinspring.model.ParkingEntity;
import com.aston.logistictestinspring.servlet.dto.ParkingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParkingMapper {
    ParkingEntity dtoToEntity(ParkingDto dto);
    ParkingDto entityToDto(ParkingEntity entity);
    List<ParkingEntity> dtoToEntityList(List<ParkingDto> dtos);
    List<ParkingDto> entityToDtoList(List<ParkingEntity> entities);
}
