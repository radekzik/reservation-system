package com.example.reservation_system.controller;

import com.example.reservation_system.dto.ReservationDto;
import com.example.reservation_system.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAll() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PostMapping
    public ResponseEntity<ReservationDto> create(@RequestBody ReservationDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationService.createReservation(dto));
    }
}
