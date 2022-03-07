package uz.pdp.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotelmanagement.model.Hotel;
import uz.pdp.hotelmanagement.model.Room;
import uz.pdp.hotelmanagement.payload.RoomDto;
import uz.pdp.hotelmanagement.repository.HotelRepository;
import uz.pdp.hotelmanagement.repository.RoomRepository;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;


    @GetMapping
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @GetMapping("/byHotel/{hotelId}")
    public Page<Room> getAllRoom(@PathVariable Integer hotelId, @RequestParam int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Room> roomsByHotelId = roomRepository.findRoomByHotelId(hotelId, pageable);
        return roomsByHotelId;

    }




    @GetMapping("/{id}")
    public Room getOneRoom(@PathVariable Integer id) {
        try {
            return roomRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Integer id) {

        try {
            roomRepository.deleteById(id);
        } catch (Exception e) {
            return "Failed to delete";
        }
        return "Successfully deleted";
    }

    @PostMapping()
    public String saveRoom(@RequestBody RoomDto roomDto){
        Room room = new Room();
        room.setFloor(roomDto.getFloor());
        room.setNumber(roomDto.getNumber());
        room.setSize(roomDto.getSize());

        Hotel hotel = hotelRepository.findById(roomDto.getHotelId()).get();
        room.setHotel(hotel);

        roomRepository.save(room);
        return "Successfully Saved";
    }

    @PutMapping("/{roomId}")
    public String editRoom(@PathVariable Integer roomId, @RequestBody RoomDto roomDto){
        Room editingRoom = roomRepository.findById(roomId).get();

        Hotel hotel = hotelRepository.findById(roomDto.getHotelId()).get();

        editingRoom.setHotel(hotel);
        editingRoom.setNumber(roomDto.getNumber());
        editingRoom.setSize(roomDto.getSize());
        editingRoom.setFloor(roomDto.getFloor());

        roomRepository.save(editingRoom);
        return "Successfully Edited";
    }



}
