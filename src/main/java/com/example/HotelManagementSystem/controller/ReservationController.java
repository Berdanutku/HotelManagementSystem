package com.example.HotelManagementSystem.controller;

import com.example.HotelManagementSystem.model.Reservation;
import com.example.HotelManagementSystem.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }
    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }
    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
    }
    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id,@RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

}
