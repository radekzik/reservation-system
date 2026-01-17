package com.example.reservation_system.repository;

import com.example.reservation_system.model.Reservation;
import com.example.reservation_system.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByRoomAndEndTimeAfterAndStartTimeBefore(Room room, LocalDateTime start, LocalDateTime end);
}