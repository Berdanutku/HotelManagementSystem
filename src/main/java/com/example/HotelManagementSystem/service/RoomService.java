package com.example.HotelManagementSystem.service;


import com.example.HotelManagementSystem.model.Room;
import com.example.HotelManagementSystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).get();
    }
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
    public void deleteRoomById(Long id) {roomRepository.deleteById(id);}
    public Room updateRoom(Long id, Room room) {
        Room oldRoom = roomRepository.findById(id).get();
        oldRoom.setRoomNumber(room.getRoomNumber());
        oldRoom.setRoomType(room.getRoomType());
        oldRoom.setPrice(room.getPrice());
        oldRoom.setAvailable(room.isAvailable());
        return roomRepository.save(oldRoom);
    }
    public List<Room> searchRooms(String roomType, Double minPrice, Double maxPrice, Boolean available) {
        return roomRepository.findByCriteria(roomType, minPrice, maxPrice, available);
    }

}
