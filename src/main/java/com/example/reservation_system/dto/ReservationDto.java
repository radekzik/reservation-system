package com.example.reservation_system.dto;

import java.time.LocalDateTime;

public record ReservationDto(
        Long id,
        Long roomId,
        String customerName,
        LocalDateTime startTime,
        LocalDateTime endTime
) {}