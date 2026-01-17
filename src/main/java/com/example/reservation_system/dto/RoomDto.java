package com.example.reservation_system.dto;

public record RoomDto(
        Long id,
        String name,
        String description,
        Integer capacity
) {}