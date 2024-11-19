package com.hexaware.HotelBooking.Service;

import com.hexaware.HotelBooking.Entity.Room;
import com.hexaware.HotelBooking.Repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
    	

        return roomRepository.save(room);
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public Room updateRoom(Long id, Room roomDetails) {
        Room room = roomRepository.findById(id).orElse(null);
        if(room!=null) {
        room.setRoomNumber(roomDetails.getRoomNumber());
        room.setRoomType(roomDetails.getRoomType());
        room.setBaseFare(roomDetails.getBaseFare());
        room.setMaxOccupancy(roomDetails.getMaxOccupancy());
        room.setHotel(roomDetails.getHotel());
        room.setIsAvailable(roomDetails.getIsAvailable());
        return roomRepository.save(room);
        }
		return room;
    }

    public String deleteRoom(Long id) {
    	Room room = roomRepository.findById(id).orElse(null);
    	if(room!=null) {
        roomRepository.deleteById(id);
    	return "Deleted";
    	}
    	else {
			return "Not Found";
    	
		}
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
