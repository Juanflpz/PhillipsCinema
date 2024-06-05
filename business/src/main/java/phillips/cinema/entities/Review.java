package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Review implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 200, nullable = false)
    @NonNull
    private String description;

    @Column(nullable = false)
    @NonNull
    private Float rate;

    @Column(nullable = false)
    @NonNull
    private LocalDate purchaseDate;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "review")
    private List<Movie> movies = new ArrayList<>();
    //METHODS--------------------------------------------------------
}
