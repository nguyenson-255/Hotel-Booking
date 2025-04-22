package com.example.hotel_api.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

     private Long bookingId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String customerName;

    private String customerEmail;

    private int numberOfAuldts;

    private int numberOfChildren;

    private int totalNumberOfGuests;

    private String bookingConfirmationCode;

    private RoomResponse room;

    public BookingResponse(Long bookingId, LocalDate checkInDate, LocalDate checkOutDate,
    String bookingConfirmationCode) {

        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
    
}
