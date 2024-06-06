package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Schedule implements Serializable {
    //ATTRIBUTES---------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private LocalDate date;

    @Column(nullable = false)
    @NonNull
    private LocalTime hour;

    //RELATIONS-----------------------------------------------------------------
    @OneToMany(mappedBy = "schedule")
    @ToString.Exclude
    private List<Performance> performances = new ArrayList<>();

    //METHODS-------------------------------------------------------------------
    public Schedule(@NonNull LocalDate date, @NonNull LocalTime hour) {
        this.date = date;
        this.hour = hour;
    }
}
