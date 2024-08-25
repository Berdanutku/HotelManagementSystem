package com.example.HotelManagementSystem.repository;


import com.example.HotelManagementSystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
