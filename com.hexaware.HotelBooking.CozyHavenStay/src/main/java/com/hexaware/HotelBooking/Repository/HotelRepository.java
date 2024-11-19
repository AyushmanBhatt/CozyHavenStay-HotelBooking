package com.hexaware.HotelBooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.HotelBooking.Entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
	List<Hotel> findByAddress(String address);
}
