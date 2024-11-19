package com.hexaware.HotelBooking.Dto;

import com.hexaware.HotelBooking.Entity.Hotel;
import com.hexaware.HotelBooking.Entity.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ReviewDTO {
	private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    public ReviewDTO() {
    	
    }

    public ReviewDTO(Long id, User user, Hotel hotel, String comment, int rating) {
		super();
		this.id = id;
		this.user = user;
		this.hotel = hotel;
		this.comment = comment;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "ReviewDTO [id=" + id + ", user=" + user + ", hotel=" + hotel + ", comment=" + comment + ", rating="
				+ rating + "]";
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
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    private String comment;
    private int rating;
}
