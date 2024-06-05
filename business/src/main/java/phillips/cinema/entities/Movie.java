package phillips.cinema.entities;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import phillips.cinema.entities.enums.MovieState;
import phillips.cinema.entities.enums.MovieType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movie implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 150, nullable = false)
    @NonNull
    private String name;

    @Lob
    @Column(nullable = false)
    @NonNull
    private String trailer;

    @Lob
    @Column(nullable = false)
    @NonNull
    private String synopsis;

    @Lob
    @Column(nullable = false)
    @NonNull
    private String cast;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NonNull
    private MovieState state;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NonNull
    private MovieType type;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKeyColumn(name = "publicIdImage")
    @Column(name = "imageURL")
    @CollectionTable(name = "movie_image")
    private Map<String, String> imagen = new HashMap<>();

    //RELATIONS------------------------------------------------------
    @ManyToMany(mappedBy = "movies")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Genre> genres = new ArrayList<>();

    @ManyToOne
    private Review review;

    @OneToMany(mappedBy = "movie")
    private List<Performance> performances = new ArrayList<>();

    //METHODS--------------------------------------------------------
}
