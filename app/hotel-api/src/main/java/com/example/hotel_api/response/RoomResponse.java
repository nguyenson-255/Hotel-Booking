package com.example.hotel_api.response;

import java.sql.Blob;
import java.util.List;

import java.util.Base64;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomResponse {
    
    private Long id;
    private String roomType;
    private String roomPrice;
    private boolean isBooked;
    private String photo;

    private List<BookingResponse> bookings;

    public RoomResponse(Long id, String roomType, String roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, String roomPrice, boolean isBooked, byte[] photoBytes,
            List<BookingResponse> bookings) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.photo = photoBytes != null ? Base64.getEncoder().encodeToString(photoBytes) : null;
        this.bookings = bookings;
    }


}
