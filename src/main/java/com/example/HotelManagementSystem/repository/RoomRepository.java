package com.example.HotelManagementSystem.repository;

import com.example.HotelManagementSystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE " +
            "(:roomType IS NULL OR r.roomType = :roomType) AND " +
            "(:minPrice IS NULL OR r.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR r.price <= :maxPrice) AND " +
            "(:available IS NULL OR r.available = :available)")
    List<Room> findByCriteria(@Param("roomType") String roomType,
                              @Param("minPrice") Double minPrice,
                              @Param("maxPrice") Double maxPrice,
                              @Param("available") Boolean available);
}
