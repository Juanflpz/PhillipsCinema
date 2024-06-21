package phillips.cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import phillips.cinema.entities.Performance;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class PurchaseDTO {
    private Float total;
    private LocalDateTime purchaseDate;
    private Performance performance;
    private Double totalFoodCost;
    private Double totalTicketCost;
}
