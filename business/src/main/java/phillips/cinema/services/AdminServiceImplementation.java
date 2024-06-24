package phillips.cinema.services;

import org.springframework.stereotype.Service;
import phillips.cinema.entities.*;
import phillips.cinema.repositories.CityAdminRepository;
import phillips.cinema.repositories.MovieTheaterRepository;
import phillips.cinema.repositories.PerformanceRepository;
import phillips.cinema.repositories.TheaterRepository;

import java.util.List;

@Service
public class AdminServiceImplementation implements AdminService {

    private final CityAdminRepository adminRepository;
    private final MovieTheaterRepository movieTheaterRepository;
    private final TheaterRepository theaterRepository;
    private final PerformanceRepository performanceRepository;

    public AdminServiceImplementation(CityAdminRepository adminRepository, MovieTheaterRepository movieTheaterRepository, TheaterRepository theaterRepository, PerformanceRepository performanceRepository) {
        this.adminRepository = adminRepository;
        this.movieTheaterRepository = movieTheaterRepository;
        this.theaterRepository = theaterRepository;
        this.performanceRepository = performanceRepository;
    }

    //Admin methods -------------------------------------------------------------------------------------

    @Override
    public CityAdmin login(String email, String password) throws Exception {
        return null;
    }

    @Override
    public CityAdmin register(CityAdmin cityAdmin) throws Exception {
        return null;
    }

    //Theater methods ------------------------------------------------------------------------------------

    @Override
    public Theater createTheater(Theater theater) throws Exception {
        return null;
    }

    @Override
    public Theater deleteTheater(Integer id) throws Exception {
        return null;
    }

    @Override
    public Theater updateTheater(Theater theater) throws Exception {
        return null;
    }

    @Override
    public Theater getTheater(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Theater> getTheaters() throws Exception {
        return List.of();
    }

    //Performance methods -------------------------------------------------------------------------------

    @Override
    public Performance createPerformance(Performance performance) throws Exception {
        return null;
    }

    @Override
    public Performance deletePerformance(Integer id) throws Exception {
        return null;
    }

    @Override
    public Performance updatePerformance(Performance performance) throws Exception {
        return null;
    }

    @Override
    public Performance getPerformance(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Performance> getPerformances() throws Exception {
        return List.of();
    }

    //MovieTheater methods ------------------------------------------------------------------------------

    @Override
    public MovieTheater createMovieTheater(MovieTheater movieTheater) throws Exception {
        return null;
    }

    @Override
    public MovieTheater deleteMovieTheater(Integer id) throws Exception {
        return null;
    }

    @Override
    public MovieTheater updateMovieTheater(MovieTheater movieTheater) throws Exception {
        return null;
    }

    @Override
    public MovieTheater getMovieTheater(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<MovieTheater> getMovieTheaters() throws Exception {
        return List.of();
    }

    //Schedule methods ---------------------------------------------------------------------------------

    @Override
    public Schedule createSchedule(Schedule schedule) throws Exception {
        return null;
    }

    @Override
    public Schedule deleteSchedule(Integer id) throws Exception {
        return null;
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) throws Exception {
        return null;
    }

    @Override
    public Schedule getSchedule(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Schedule> getSchedules() throws Exception {
        return List.of();
    }
}
