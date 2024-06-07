package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.PurchaseFood;

@Repository
public interface PurchaseFoodRepository extends JpaRepository<PurchaseFood, Integer> {
}
