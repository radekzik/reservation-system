package com.example.reservation_system.mapper;

import com.example.reservation_system.dto.ReservationDto;
import com.example.reservation_system.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "roomId", source = "room.id")
    ReservationDto toDto(Reservation entity);

    @Mapping(target = "room", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Reservation toEntity(ReservationDto dto);
}