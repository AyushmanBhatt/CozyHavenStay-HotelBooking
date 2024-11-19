package com.hexaware.HotelBooking.Controller;

import com.hexaware.HotelBooking.Dto.BookingDTO;
import com.hexaware.HotelBooking.Entity.Booking;
import com.hexaware.HotelBooking.Exception.BookingNotFoundException;
import com.hexaware.HotelBooking.Service.BookingService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ModelMapper mp;

    @PostMapping("/createbooking")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingdto) {
        Booking booking = mp.map(bookingdto, Booking.class);
        Booking savedBooking = bookingService.createBooking(booking);
        BookingDTO response = mp.map(savedBooking, BookingDTO.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("getbookingbyid/{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id) throws BookingNotFoundException {
        Booking booking = bookingService.getBookingById(id);
        if (booking!=null) {
            BookingDTO bookingDTO = mp.map(booking, BookingDTO.class);
            return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
        } else {
            throw new BookingNotFoundException("Booking not found");
        }
    }

    @PutMapping("/updatebookingbyid/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDto) {
        Booking booking = mp.map(bookingDto, Booking.class);
        Booking updatedBooking = bookingService.updateBooking(id, booking);
        if(updatedBooking!=null) {
        BookingDTO bookingDTO = mp.map(updatedBooking, BookingDTO.class);
        return new ResponseEntity<>(bookingDTO, HttpStatus.OK);
        }
        else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("/deletebookingbyid/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) throws BookingNotFoundException {
        if(bookingService.deleteBooking(id).equals("Deleted")) {
        	return new ResponseEntity<String>("Deleted",HttpStatus.OK);
        }
        else
        throw new BookingNotFoundException("Booking doesn not exist with entered booking id");
    }

    @GetMapping("/allbookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        if(bookings.isEmpty()) {
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }
        else {
        	List<BookingDTO> li = bookings.stream().map((temp)->mp.map(temp, BookingDTO.class)).toList();
        	return new ResponseEntity<List<BookingDTO>>(li,HttpStatus.OK);
        }
    }
    
    @GetMapping("getbookingbyuserid/{userid}")
    public ResponseEntity<List<BookingDTO>> getBookinguser(@PathVariable Long userid) throws BookingNotFoundException {
        List<Booking> booking = bookingService.getBookingByUserId(userid);
        if(booking.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
            }
            else {
            	List<BookingDTO> li = booking.stream().map((temp)->mp.map(temp, BookingDTO.class)).toList();
            	return new ResponseEntity<List<BookingDTO>>(li,HttpStatus.OK);
            }
    }
    
	
	  @GetMapping("getbookingbyhotelid/{hotelid}")
	  public ResponseEntity<List<BookingDTO>> getBookinghotel(@PathVariable Long hotelid) throws BookingNotFoundException 
	  { 
		  List<Booking> booking =bookingService.getBookingByHotelId(hotelid); 
		  if(booking.isEmpty()) 
		  { 
			  return new ResponseEntity<>( HttpStatus.NO_CONTENT); 
		  } 
		  else 
		  { 
			  List<BookingDTO> li = booking.stream().map((temp)->mp.map(temp, BookingDTO.class)).toList();
			  return new ResponseEntity<List<BookingDTO>>(li,HttpStatus.OK); 
		  }
		  
	  }
	 
}
