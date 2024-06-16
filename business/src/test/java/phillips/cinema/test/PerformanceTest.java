package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.DTO.PerformanceDTO;
import phillips.cinema.entities.*;
import phillips.cinema.entities.enums.PerformanceType;
import phillips.cinema.repositories.PerformanceRepository;

import java.util.List;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PerformanceTest {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Movie movie = new Movie();
        MovieTheater movieTheater = new MovieTheater();
        Schedule schedule = new Schedule();
        Performance performance = new Performance(PerformanceType.PERFORMANCE_3D, 50.3f, movie, movieTheater, schedule);
        Performance saved = performanceRepository.save(performance);

        Assertions.assertEquals(PerformanceType.PERFORMANCE_3D, saved.getType());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Performance saved = performanceRepository.findById(1).orElse(null);
        performanceRepository.delete(saved);

        Assertions.assertNull(performanceRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Performance saved = performanceRepository.findById(1).orElse(null);
        saved.setId(6);
        Performance performance = performanceRepository.save(saved);

        Assertions.assertEquals(6, performance.getId());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Performance saved = performanceRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Performance> saved = performanceRepository.findAll();
        System.out.println(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getMoviePerformance(){
        String movieName = performanceRepository.getMovieName(1);
        System.out.println(movieName);
        Assertions.assertEquals("Spider-Man: No Way Home", movieName);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findMovies(){
        List<Movie> movies = performanceRepository.findMovies();
        movies.forEach(System.out::println);
        Assertions.assertNotNull(movies);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listPerformances(){
        List<Object[]> performances = performanceRepository.listPerformances(1);
        performances.forEach( o ->
                System.out.println(o[0] + ", " + o[1] + ", " + o[2] + ", " + o[3] + ", " + o[4] + ", " + o[5] + ", " + o[6])
        );
        Assertions.assertNotNull(performances);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listPerformances2(){
        List<PerformanceDTO> performances = performanceRepository.listPerformances2(1);
        performances.forEach(System.out::println);
        Assertions.assertNotNull(performances);
    }
}
