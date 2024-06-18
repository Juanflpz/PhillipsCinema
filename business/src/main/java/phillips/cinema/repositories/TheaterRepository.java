package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Performance;
import phillips.cinema.entities.Theater;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    @Query("select t from Theater t where t.city.cityName = :cityName")
    List<Theater> findTheatersByCityName(String cityName);

    @Query("select count(t), c.cityName from Theater t join t.city c on t.city.id = c.id group by c.cityName order by count(t)")
    List<Object[]> findTheatersByCity();

    @Query("select p from Performance p join p.movieTheater.theater t where t.id = ?3 and p.schedule.date between ?1 and ?2")
    List<Performance> listPerformancesByTheaterAndDate(LocalDate date1, LocalDate date2, Integer theaterID);
}
