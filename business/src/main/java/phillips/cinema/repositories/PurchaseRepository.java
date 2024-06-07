package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
