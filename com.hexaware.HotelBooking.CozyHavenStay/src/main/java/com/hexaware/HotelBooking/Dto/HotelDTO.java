package com.hexaware.HotelBooking.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hexaware.HotelBooking.Entity.Hotel;
import com.hexaware.HotelBooking.Entity.Room;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class HotelDTO {
	private Long id;

    private String name;
    private String address;
    private String description;
    private String phoneNo;
    
    

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getHotelimage() {
		return Hotelimage;
	}

	public void setHotelimage(String hotelimage) {
		Hotelimage = hotelimage;
	}

	private String amenities;
    private String Hotelimage;
    
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Room> rooms;
    

	
	
	public HotelDTO(Long id, String name, String address, String description, String phoneNo, String amenities,
			String hotelimage, List<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.phoneNo = phoneNo;
		this.amenities = amenities;
		Hotelimage = hotelimage;
		this.rooms = rooms;
		
	}

	

	public HotelDTO() {
		
	}

	@Override
	public String toString() {
		return "HotelDTO [id=" + id + ", name=" + name + ", address=" + address + ", description=" + description
				+ ", phoneNo=" + phoneNo + ", amenities=" + amenities + ", Hotelimage=" + Hotelimage + ", rooms="
				+ rooms + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
