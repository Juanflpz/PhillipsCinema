package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.Movie;
import phillips.cinema.entities.MovieTheater;
import phillips.cinema.entities.Performance;
import phillips.cinema.entities.Schedule;
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
}
