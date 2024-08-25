package com.example.HotelManagementSystem.controller;

import com.example.HotelManagementSystem.model.Room;
import com.example.HotelManagementSystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }
    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) {
        roomService.deleteRoomById(id);
    }
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id,@RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }
    @GetMapping("/search")
    public List<Room> searchRooms(
            @RequestParam(required = false) String roomType,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Boolean available) {
        return roomService.searchRooms(roomType, minPrice, maxPrice, available);
    }


}


