package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
