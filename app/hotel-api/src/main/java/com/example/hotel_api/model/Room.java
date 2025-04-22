package com.example.hotel_api.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "room_price")
    private BigDecimal roomPrice;

    @Column(name = "is_booked")
    private boolean isBooked = false;

    @Lob
    private Blob photo;

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    private List<BookedRoom> bookings;

    public Room() {
        this.bookings = new ArrayList<>();
    }

    public void addBooking(BookedRoom booking) {
        if (this.bookings == null) {
            this.bookings = new ArrayList<>();
        }
        this.bookings.add(booking);
        booking.setRoom(this);
        this.isBooked = true;
        booking.setBookingConfirmationCode(RandomStringUtils.randomNumeric(10));
    }

    public void removeBooking(BookedRoom booking) {
        this.bookings.remove(booking);
        booking.setRoom(null);
    }
}
