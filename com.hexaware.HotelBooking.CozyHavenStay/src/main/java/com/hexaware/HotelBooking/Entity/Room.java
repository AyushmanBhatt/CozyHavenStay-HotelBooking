package com.hexaware.HotelBooking.Entity;


import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String roomType; // e.g., "Single", "Double", "King"
    private BigDecimal baseFare;
    private int maxOccupancy; // Max number of people allowed in the room

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;
    
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking; // A room can be booked

    private boolean isAvailable;

    public Room(Long id, String roomNumber, String roomType, BigDecimal baseFare, int maxOccupancy, Hotel hotel,
			Booking booking, boolean isAvailable) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.baseFare = baseFare;
		this.maxOccupancy = maxOccupancy;
		this.hotel = hotel;
		this.booking = booking;
		this.isAvailable = isAvailable;
	}
    
    Room(){
    	
    }

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", baseFare=" + baseFare
				+ ", maxOccupancy=" + maxOccupancy + ", hotel=" + hotel + ", booking=" + booking + ", isAvailable="
				+ isAvailable + "]";
	}

	

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
