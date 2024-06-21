package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.DTO.MovieDTO;
import phillips.cinema.entities.Genre;
import phillips.cinema.entities.Movie;
import phillips.cinema.repositories.MovieRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Map<String, String> image = new HashMap<>();
        List<Genre> genres = new ArrayList<>();
        Movie movie = new Movie("CARS 2", "youtube.com/hagshashhasha", "no synopsis", "no cast", image, genres);
        Movie saved = movieRepository.save(movie);

        Assertions.assertEquals("CARS 2", saved.getName());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Movie saved = movieRepository.findById(1).orElse(null);
        movieRepository.delete(saved);

        Assertions.assertNull(movieRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Movie saved = movieRepository.findById(1).orElse(null);
        saved.setId(6);
        Movie food = movieRepository.save(saved);

        Assertions.assertEquals(6, food.getId());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Movie saved = movieRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Movie> saved = movieRepository.findAll();
        System.out.println(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void searchAvailableMovieByFilter(){
        List<Movie> movies = movieRepository.searchAvailableMovieByFilter("an");
        movies.forEach(System.out::println);
        Assertions.assertNotNull(movies);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void searchAnyMovieByFilter(){
        List<Movie> movies = movieRepository.searchAnyMovieByFilter("an");
        movies.forEach(System.out::println);
        Assertions.assertNotNull(movies);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void AdditionalMovieInfo(){
        List<MovieDTO> info = movieRepository.AdditionalMovieInfo(1, 1);
        info.forEach(System.out::println);
        Assertions.assertNotNull(info);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findMoviesByGenre(){
        List<Movie> movies = movieRepository.findMoviesByGenre(1);
        movies.forEach(System.out::println);
        Assertions.assertNotNull(movies);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findMostViewedMovieInCity(){
        List<Object[]> movies = movieRepository.findMostViewedMovieInCity(2);
        List<Object[]> movies1 = new ArrayList<>();
        movies1.add(movies.get(0));
        movies1.forEach( o ->
                System.out.println(o[0] + ", " + o[1])
        );
        Assertions.assertNotNull(movies1);
    }
}
