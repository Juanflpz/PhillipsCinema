package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.CityAdmin;

@Repository
public interface CityAdminRepository extends JpaRepository<CityAdmin, Integer> {
}
