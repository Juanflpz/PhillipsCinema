package phillips.cinema.entities;

import lombok.*;
import phillips.cinema.entities.enums.PerformanceState;
import phillips.cinema.entities.enums.PerformanceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Performance implements Serializable {
    //ATTRIBUTES-----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NonNull
    private PerformanceType type;

    //when a performance is created it means it´s available for its purchase
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private PerformanceState state = PerformanceState.AVAILABLE;

    @Column(nullable = false)
    @NonNull
    private Float price;

    //RELATIONS-----------------------------------------------------------------
    /*
    @OneToMany(mappedBy = "performance")
    @ToString.Exclude
    private List<Purchase> purchases = new ArrayList<>();
    */
    @ManyToOne
    @NonNull
    private Movie movie;

    @ManyToOne
    @NonNull
    private MovieTheater movieTheater;

    @ManyToOne
    @NonNull
    private Schedule schedule;

    @ToString.Exclude
    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "performance")
    private List<Purchase> purchases = new ArrayList<>();

    //METHODS----------------------------------------------------------------
    public Performance(@NonNull PerformanceType type, @NonNull Float price, @NonNull Movie movie, @NonNull MovieTheater movieTheater, @NonNull Schedule schedule) {
        this.type = type;
        this.price = price;
        this.movie = movie;
        this.movieTheater = movieTheater;
        this.schedule = schedule;
    }
}
