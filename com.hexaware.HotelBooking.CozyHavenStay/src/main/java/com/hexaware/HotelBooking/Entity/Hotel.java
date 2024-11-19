package com.hexaware.HotelBooking.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNo;
    private String description;
    private String amenities;
    private String Hotelimage;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    
    private List<Room> rooms;
    
    
    public Hotel(Long id, String name, String address, String phoneNo, String description, String amenities,
			String hotelimage, List<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.description = description;
		this.amenities = amenities;
		Hotelimage = hotelimage;
		this.rooms = rooms;
		
	}

	

	
    
    public Hotel() {
    	
    }

	 

    @Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", phoneNo=" + phoneNo + ", description="
				+ description + ", amenities=" + amenities + ", Hotelimage=" + Hotelimage + ", rooms=" + rooms
				+ "]";
	}


	

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getHotelimage() {
		return Hotelimage;
	}

	public void setHotelimage(String hotelimage) {
		Hotelimage = hotelimage;
	}
}
