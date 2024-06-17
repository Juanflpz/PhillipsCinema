package phillips.cinema.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Getter
@ToString
public class MovieDTO {
    private LocalTime hour;
    private LocalDate date;
    private Integer id;
    private Integer seats;
}
