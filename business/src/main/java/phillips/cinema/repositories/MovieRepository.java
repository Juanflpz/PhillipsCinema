package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.DTO.MovieDTO;
import phillips.cinema.entities.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("select m from Movie m where m.name LIKE %:searchString% and (m.state = 'EXHIBITED' OR m.state = 'NOT_EXHIBITED')")
    List<Movie> searchByFilter(String searchString);

    @Query("select new phillips.cinema.DTO.MovieDTO(s.hour, s.date, mt.id, mt.seats) from Movie m join Performance p on m.id = p.movie.id join p.schedule s join p.movieTheater mt join p.movieTheater.theater t where t.id = ?1")
    List<MovieDTO> AdditionalMovieInfo(Integer theaterID);

    @Query("select m from Movie m join m.genres g where g.id = :genreID ORDER BY m.name ASC")
    List<Movie> findMoviesByGenre(Integer genreID);

    @Query("select m.name from Movie m join Performance p join p.movieTheater.theater.city c where c.id = ?1")
    Movie findMostSeenMovieByCity(Integer cityID);
}
