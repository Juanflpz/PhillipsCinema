package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}
