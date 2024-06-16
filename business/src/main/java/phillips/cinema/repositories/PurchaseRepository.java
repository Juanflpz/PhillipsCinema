package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Purchase;
import phillips.cinema.entities.Ticket;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("select p.tickets from Purchase p where p.id = ?1")
    List<Ticket> findTicketsByPurchase(Integer purchaseID);
}
