package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.City;
import phillips.cinema.entities.Theater;
import phillips.cinema.repositories.TheaterRepository;

import java.util.List;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TheaterTest {

    @Autowired
    private TheaterRepository theaterRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        City city = new City();
        Theater theater = new Theater("PHILLIPS CINEMA", "CR 23 12 #56", city);
        Theater saved = theaterRepository.save(theater);

        Assertions.assertEquals("PHILLIPS CINEMA", saved.getName());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Theater saved = theaterRepository.findById(1).orElse(null);
        theaterRepository.delete(saved);

        Assertions.assertNull(theaterRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Theater saved = theaterRepository.findById(1).orElse(null);
        saved.setId(6);
        Theater theater = theaterRepository.save(saved);

        Assertions.assertEquals(6, theater.getId());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Theater saved = theaterRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Theater> saved = theaterRepository.findAll();
        System.out.println(saved);
    }
}
