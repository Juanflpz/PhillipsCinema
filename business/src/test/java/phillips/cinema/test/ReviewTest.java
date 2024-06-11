package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.Movie;
import phillips.cinema.entities.Review;
import phillips.cinema.entities.Schedule;
import phillips.cinema.repositories.ReviewRepository;
import phillips.cinema.repositories.ScheduleRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReviewTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Client client = new Client();
        Movie movie = new Movie();
        Review review = new Review("heeeey, heres my description", 4.8f, client, movie);
        Review saved = reviewRepository.save(review);

        Assertions.assertEquals(4.8f, saved.getRate());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Review saved = reviewRepository.findById(1).orElse(null);
        reviewRepository.delete(saved);

        Assertions.assertNull(reviewRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Review saved = reviewRepository.findById(1).orElse(null);
        saved.setId(10);
        Review saved1 = reviewRepository.save(saved);

        Assertions.assertEquals(10, saved1.getId());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Review saved = reviewRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Review> saved = reviewRepository.findAll();
        System.out.println(saved);
    }
}
