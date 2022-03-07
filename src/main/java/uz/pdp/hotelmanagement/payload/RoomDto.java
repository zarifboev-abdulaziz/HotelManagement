package uz.pdp.hotelmanagement.payload;

import lombok.Data;
import uz.pdp.hotelmanagement.model.Hotel;

import javax.jnlp.IntegrationService;
import javax.persistence.ManyToOne;

@Data
public class RoomDto {
    private Integer number;
    private Integer floor;
    private Double size;
    private Integer hotelId;

}
