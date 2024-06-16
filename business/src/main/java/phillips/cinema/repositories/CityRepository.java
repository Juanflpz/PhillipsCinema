package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.City;
import phillips.cinema.entities.Theater;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select c.theaters from City c where c.cityName = :cityName")
    List<Theater> findTheatersByCity(String cityName);
}
