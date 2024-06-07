package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
