package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.MovieTheater;

@Repository
public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Integer> {
}
