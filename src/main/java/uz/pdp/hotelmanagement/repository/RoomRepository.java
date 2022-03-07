package uz.pdp.hotelmanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.hotelmanagement.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    Page<Room> findRoomByHotelId(Integer hotel_id, Pageable pageable);
}
