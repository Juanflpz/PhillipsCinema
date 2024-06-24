package phillips.cinema.services;

import phillips.cinema.entities.*;

import java.util.List;

public interface AdminService {
    CityAdmin login(String email, String password) throws Exception;

    CityAdmin register(CityAdmin cityAdmin) throws Exception;

    Theater createTheater(Theater theater) throws Exception;

    Theater deleteTheater(Integer id) throws Exception;

    Theater updateTheater(Theater theater) throws Exception;

    Theater getTheater(Integer id) throws Exception;

    List<Theater> getTheaters() throws Exception;

    Performance createPerformance(Performance performance) throws Exception;

    Performance deletePerformance(Integer id) throws Exception;

    Performance updatePerformance(Performance performance) throws Exception;

    Performance getPerformance(Integer id) throws Exception;

    List<Performance> getPerformances() throws Exception;

    MovieTheater createMovieTheater(MovieTheater movieTheater) throws Exception;

    MovieTheater deleteMovieTheater(Integer id) throws Exception;

    MovieTheater updateMovieTheater(MovieTheater movieTheater) throws Exception;

    MovieTheater getMovieTheater(Integer id) throws Exception;

    List<MovieTheater> getMovieTheaters() throws Exception;

    Schedule createSchedule(Schedule schedule) throws Exception;

    Schedule deleteSchedule(Integer id) throws Exception;

    Schedule updateSchedule(Schedule schedule) throws Exception;

    Schedule getSchedule(Integer id) throws Exception;

    List<Schedule> getSchedules() throws Exception;
}
