package com.example.reservation_system.service;

import com.example.reservation_system.dto.ReservationDto;
import com.example.reservation_system.exception.ConflictException;
import com.example.reservation_system.exception.ResourceNotFoundException;
import com.example.reservation_system.mapper.ReservationMapper;
import com.example.reservation_system.model.Reservation;
import com.example.reservation_system.model.Room;
import com.example.reservation_system.repository.ReservationRepository;
import com.example.reservation_system.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final ReservationMapper reservationMapper;

    @Transactional(readOnly = true)
    public List<ReservationDto> getAllReservations() {
        log.info("Fetching all reservations");
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toDto)
                .toList();
    }

    @Transactional
    public ReservationDto createReservation(ReservationDto dto) {
        log.info("Attempting to create reservation for room ID: {}", dto.roomId());

        Room room = roomRepository.findById(dto.roomId())
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with ID: " + dto.roomId()));


        boolean isOccupied = reservationRepository.existsByRoomAndEndTimeAfterAndStartTimeBefore(
                room, dto.startTime(), dto.endTime());

        if (isOccupied) {
            log.warn("Reservation conflict for room: {}", room.getName());
            throw new ConflictException("Room is already occupied for the selected time.");
        }


        Reservation reservation = reservationMapper.toEntity(dto);
        reservation.setRoom(room);

        Reservation saved = reservationRepository.save(reservation);
        log.info("Reservation created with ID: {}", saved.getId());

        return reservationMapper.toDto(saved);
    }
}