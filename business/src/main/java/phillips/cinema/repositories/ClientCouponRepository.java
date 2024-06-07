package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.ClientCoupon;

@Repository
public interface ClientCouponRepository extends JpaRepository<ClientCoupon, Integer> {
}
