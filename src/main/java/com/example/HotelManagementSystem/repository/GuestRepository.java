package com.example.HotelManagementSystem.repository;


import com.example.HotelManagementSystem.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
