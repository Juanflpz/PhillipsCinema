package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.DTO.PerformanceDTO;
import phillips.cinema.entities.Movie;
import phillips.cinema.entities.Performance;

import java.util.List;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Integer> {

    @Query("select p.movie.name from Performance p where p.id = :performanceID")
    String findMovieName(Integer performanceID);

    @Query("select distinct p.movie from Performance p")
    List<Movie> findMovies();

    @Query("select p.movie.name, p.movie.state, p.movie.image.size, p.movieTheater.id, p.movieTheater.theater.address, p.movieTheater.theater.city.cityName, p.schedule from Performance p where p.movie.id = :movieID")
    List<Object[]> listPerformances(Integer movieID);

    @Query("select new phillips.cinema.DTO.PerformanceDTO( p.movie.name, p.movie.state, p.movie.image.size, p.movieTheater.id, p.movieTheater.theater.address, p.movieTheater.theater.city.cityName, p.schedule ) from Performance p where p.movie.id = :movieID")
    List<PerformanceDTO> listPerformances2(Integer movieID);
}
