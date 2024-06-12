package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.MovieTheater;
import phillips.cinema.entities.Theater;
import phillips.cinema.entities.enums.MovieTheaterType;
import phillips.cinema.repositories.MovieTheaterRepository;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieTheaterTest {

    @Autowired
    private MovieTheaterRepository movieTheaterRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Theater theater = new Theater();
        List<MovieTheaterType> list = new ArrayList<>();
        list.add(MovieTheaterType.TYPE_2D);
        MovieTheater movieTheater = new MovieTheater(50, 5, 10, theater, list);
        MovieTheater saved = movieTheaterRepository.save(movieTheater);

        Assertions.assertEquals(50, saved.getSeats());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        MovieTheater saved = movieTheaterRepository.findById(1).orElse(null);
        movieTheaterRepository.delete(saved);

        Assertions.assertNull(movieTheaterRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        MovieTheater saved = movieTheaterRepository.findById(1).orElse(null);
        saved.setId(6);
        MovieTheater movieTheater = movieTheaterRepository.save(saved);

        Assertions.assertEquals(6, movieTheater.getId());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        MovieTheater saved = movieTheaterRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<MovieTheater> saved = movieTheaterRepository.findAll();
        System.out.println(saved);
    }
}
