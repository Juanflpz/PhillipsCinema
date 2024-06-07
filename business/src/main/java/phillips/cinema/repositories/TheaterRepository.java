package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
