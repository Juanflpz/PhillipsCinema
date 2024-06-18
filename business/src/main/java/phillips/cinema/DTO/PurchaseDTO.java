package phillips.cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class PurchaseDTO {
    private Integer purchaseID;
    private Float totalAmount;
    private LocalDateTime purchaseDate;
    private Integer performanceID;
    private Float foodsAmount;
    private Float ticketAmount;
}
