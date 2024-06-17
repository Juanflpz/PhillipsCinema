package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Theater;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {

    @Query("select t from Theater t where t.city.cityName = :cityName")
    List<Theater> findTheatersByCityName(String cityName);

    @Query("select count(t), c.cityName from Theater t join t.city c on t.city.id = c.id group by c.cityName order by count(t)")
    List<Object[]> findTheatersByCity();
}
