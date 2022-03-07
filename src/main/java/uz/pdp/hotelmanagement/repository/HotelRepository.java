package uz.pdp.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.hotelmanagement.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
