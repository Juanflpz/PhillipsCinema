package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.City;
import phillips.cinema.entities.Theater;
import phillips.cinema.entities.enums.Department;
import phillips.cinema.repositories.CityRepository;
import phillips.cinema.repositories.TicketRepository;

import java.util.List;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CityTest {

    @Autowired //automatically load without instantiating it
    private CityRepository cityRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        City city = new City("HOLA", Department.ARAUCA);
        City savedCity = cityRepository.save(city);
        Assertions.assertEquals(Department.ARAUCA, savedCity.getDepartment());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        City city = cityRepository.findById(1).orElse(null);
        cityRepository.delete(city);

        Assertions.assertNull(cityRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        City city = cityRepository.findById(1).orElse(null);
        city.setCityName("Adios");

        Assertions.assertEquals("Adios", city.getCityName());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        City city = cityRepository.findById(1).orElse(null);
        System.out.println(city);
        Assertions.assertNotNull(city);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<City> cities = cityRepository.findAll();
        System.out.println(cities);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findTheatersByCity(){
        List<Theater> saved = cityRepository.findTheatersByCity("Medellin");
        Assertions.assertNotNull(saved);
    }
}
