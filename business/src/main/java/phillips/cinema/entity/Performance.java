package phillips.cinema.entity;

import lombok.*;

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
    private PerformanceType type;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private PerformanceState state;

    @Column(nullable = false)
    private Float price;

    //RELATIONS-----------------------------------------------------------------
    @OneToMany(mappedBy = "performance")
    @ToString.Exclude
    private List<Purchase> purchases = new ArrayList<>();

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private MovieTheater movieTheater;

    @ManyToOne
    private Schedule schedule;

    @OneToMany(mappedBy = "performance")
    private List<Ticket> tickets = new ArrayList<>();

    //METHODS----------------------------------------------------------------
}
