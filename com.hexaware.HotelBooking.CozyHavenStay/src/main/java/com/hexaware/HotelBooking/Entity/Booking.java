package com.hexaware.HotelBooking.Entity;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id") 
    private Hotel hotel;

    @Override
	public String toString() {
		return "Booking [id=" + id + ", user=" + user + ", room=" + room + ", hotel=" + hotel + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + ", isCancelled=" + isCancelled + ", totalAmount="
				+ totalAmount + "]";
	}

	public Booking(Long id, User user, Room room, Hotel hotel, LocalDate checkInDate, LocalDate checkOutDate,
			boolean isCancelled, BigDecimal totalAmount) {
		super();
		this.id = id;
		this.user = user;
		this.room = room;
		this.hotel = hotel;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.isCancelled = isCancelled;
		this.totalAmount = totalAmount;
	}
	
	Booking(){
		
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	private LocalDate checkInDate;
    private LocalDate checkOutDate;

    private boolean isCancelled;

    private BigDecimal totalAmount;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
