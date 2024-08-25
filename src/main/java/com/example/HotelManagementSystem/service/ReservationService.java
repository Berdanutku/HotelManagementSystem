package com.example.HotelManagementSystem.service;

import com.example.HotelManagementSystem.model.Reservation;
import com.example.HotelManagementSystem.model.ReservationStatus;
import com.example.HotelManagementSystem.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }
    public Reservation saveReservation(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.PENDING);
        return reservationRepository.save(reservation);
    }
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
    public Reservation updateReservation(Long id,Reservation reservation) {
        Reservation oldReservation = reservationRepository.findById(id).get();
        oldReservation.setRoom(reservation.getRoom());
        oldReservation.setGuest(reservation.getGuest());
        oldReservation.setCheckIn(reservation.getCheckIn());
        oldReservation.setCheckOut(reservation.getCheckOut());
        oldReservation.setReservationStatus(reservation.getReservationStatus());
        return reservationRepository.save(oldReservation);
    }
}
