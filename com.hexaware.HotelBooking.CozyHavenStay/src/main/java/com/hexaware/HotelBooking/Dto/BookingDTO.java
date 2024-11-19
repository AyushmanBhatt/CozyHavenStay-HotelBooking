package com.hexaware.HotelBooking.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.hexaware.HotelBooking.Entity.Hotel;
import com.hexaware.HotelBooking.Entity.Room;
import com.hexaware.HotelBooking.Entity.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BookingDTO {
	private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
	public String toString() {
		return "BookingDTO [id=" + id + ", user=" + user + ", room=" + room + ", hotel=" + hotel + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + ", isCancelled=" + isCancelled + ", totalAmount="
				+ totalAmount + "]";
	}

	
	
	public BookingDTO() {
		
	}

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

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
	@ManyToOne
    @JoinColumn(name = "hotel_id") 
    private Hotel hotel;

    public BookingDTO(Long id, User user, Room room, Hotel hotel, LocalDate checkInDate, LocalDate checkOutDate,
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

}
