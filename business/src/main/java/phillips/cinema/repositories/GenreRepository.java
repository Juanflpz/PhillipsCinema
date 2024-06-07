package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
