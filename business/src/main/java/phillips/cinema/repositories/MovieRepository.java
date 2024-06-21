package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.DTO.MovieDTO;
import phillips.cinema.entities.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //LIKE CONCAT('%', :searchString, '%')
    @Query("select m from Movie m where m.name LIKE %:searchString% and (m.type = 'PREMIERE' OR m.type = 'PREVIEW') and (m.state != 'NOT_EXHIBITED')")
    List<Movie> searchAvailableMovieByFilter(String searchString);

    @Query("select m from Movie m where m.name LIKE %:searchString% and (m.state = 'NOT_EXHIBITED' OR m.state = 'EXHIBITED')")
    List<Movie> searchAnyMovieByFilter(String searchString);

    //function that provides the schedules and movie theaters of a specific movie and theater
    @Query("select new phillips.cinema.DTO.MovieDTO(m.name, s.hour, s.date, mt.id, mt.seats) from Movie m join Performance p on m.id = p.movie.id join p.schedule s join p.movieTheater mt join p.movieTheater.theater t where t.id = ?1 and m.id = ?2")
    List<MovieDTO> AdditionalMovieInfo(Integer theaterID, Integer movieID);

    @Query("select m from Movie m join m.genres g where g.id = :genreID ORDER BY m.name ASC")
    List<Movie> findMoviesByGenre(Integer genreID);

    //@Query("select p.performance.movie from Purchase p where p.performance.movieTheater.theater.city.id = ?1")
    //@Query("select m.name, max(count(t)) from Movie m join Performance p on m.id = p.movie.id join Purchase ps on p.id = ps.performance.id join Ticket t on t.purchase.id = ps.id join p.movieTheater.theater.city c where c.id = ?1 group by m.name")
    //Movie findMostSeenMovieByCity(Integer cityID);

    @Query("SELECT m, COUNT(t.id) AS ticket_count " +
            "FROM Ticket t " +
            "JOIN t.performance p " +
            "JOIN p.movie m " +
            "JOIN p.movieTheater mt " +
            "JOIN mt.theater th " +
            "WHERE th.city.id = :city " +
            "GROUP BY m.id " +
            "ORDER BY ticket_count DESC")
    List<Object[]> findMostViewedMovieInCity(Integer city);
}
