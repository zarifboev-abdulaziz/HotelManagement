package uz.pdp.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotelmanagement.model.Hotel;
import uz.pdp.hotelmanagement.repository.HotelRepository;

import javax.swing.plaf.synth.Region;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;


    @GetMapping
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getOneHotel(@PathVariable Integer id) {
        return hotelRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Integer id) {

        try {
            hotelRepository.deleteById(id);
        } catch (Exception e) {
            return "Failed to delete";
        }
        return "Successfully deleted";
    }

    @PostMapping
    public String saveHotel(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
        return "Successfully saved";
    }

    @PutMapping("/{id}")
    public String editHotel(@RequestBody Hotel hotel, @PathVariable Integer id) {
        Hotel hotelById = hotelRepository.getById(id);
        hotelById.setName(hotel.getName());

        hotelRepository.save(hotelById);
        return "Successfully edited";
    }

}
