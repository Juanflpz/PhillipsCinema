package phillips.cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import phillips.cinema.entities.Schedule;
import phillips.cinema.entities.enums.MovieState;

@AllArgsConstructor
@Getter
@ToString
public class PerformanceDTO {
    private String movieName;
    private MovieState movieState;
    private Integer image;
    private Integer movieTheaterID;
    private String theaterAddress;
    private String cityName;
    private Schedule schedule;
}
