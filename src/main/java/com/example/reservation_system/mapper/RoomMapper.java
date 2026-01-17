package com.example.reservation_system.mapper;

import com.example.reservation_system.dto.RoomDto;
import com.example.reservation_system.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto toDto(Room entity);

    @Mapping(target = "reservations", ignore = true)
    Room toEntity(RoomDto dto);
}