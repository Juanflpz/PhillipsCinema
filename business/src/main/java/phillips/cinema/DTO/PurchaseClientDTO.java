package phillips.cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.Purchase;

@AllArgsConstructor
@Getter
@ToString
public class PurchaseClientDTO {
    private Client client;
    private Purchase purchase;
}
