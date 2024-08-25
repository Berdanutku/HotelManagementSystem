package com.example.HotelManagementSystem.controller;

import com.example.HotelManagementSystem.model.Guest;
import com.example.HotelManagementSystem.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }
    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id);
    }
    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.saveGuest(guest);
    }
    @DeleteMapping("/{id}")
    public void deleteGuestById(@PathVariable Long id) {
        guestService.deleteGuestById(id);
    }
    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id,@RequestBody Guest guest) {
        return guestService.updateGuest(id, guest);
    }


}