package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
