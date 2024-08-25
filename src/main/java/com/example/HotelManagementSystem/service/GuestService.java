package com.example.HotelManagementSystem.service;


import com.example.HotelManagementSystem.model.Guest;
import com.example.HotelManagementSystem.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }
    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).get();
    }
    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }
    public void deleteGuestById(Long id) {guestRepository.deleteById(id);}
    public Guest updateGuest(Long id,Guest guest) {
        Guest oldGuest = guestRepository.findById(id).get();
        oldGuest.setName(guest.getName());
        oldGuest.setEmail(guest.getEmail());
        oldGuest.setPhone(guest.getPhone());
        return guestRepository.save(oldGuest);
    }
}
