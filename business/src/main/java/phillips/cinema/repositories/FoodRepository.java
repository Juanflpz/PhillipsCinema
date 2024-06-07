package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
