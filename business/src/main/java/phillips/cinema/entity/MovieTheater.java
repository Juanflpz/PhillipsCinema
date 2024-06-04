package phillips.cinema.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
public class MovieTheater implements Serializable {
    //ATTRIBUTES-----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private Integer seats;

    @Column(nullable = false)
    private Integer rows;

    @Column(nullable = false)
    private Integer columns;

    @ElementCollection(targetClass = MovieTheaterType.class) //Indica que types es una colección de elementos básicos o embebidos de MovieTheaterType.
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "movie_theater_types", joinColumns = @JoinColumn(name = "movie_theater_id")) //tabla y key del join
    @Column(name = "type", nullable = false)
    private List<MovieTheaterType> movie_theater_types = new ArrayList<>();

    //RELATIONS------------------------------------------------------
    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "movieTheater")
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "movieTheater")
    private List<Performance> performances = new ArrayList<>();

    //METHODS--------------------------------------------------------
}
