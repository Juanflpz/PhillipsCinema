package phillips.cinema.entities;

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
public class Theater implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 50, nullable = false)
    @NonNull
    private String name;

    @Column(length = 50, nullable = false)
    @NonNull
    private String address;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    @NonNull
    private City city;

    @ManyToOne
    private CityAdmin admin;

    @OneToMany(mappedBy = "theater")
    private List<MovieTheater> movieTheaters = new ArrayList<>();

    //METHODS--------------------------------------------------------
    public Theater(@NonNull String name, @NonNull String address, @NonNull City city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
}
