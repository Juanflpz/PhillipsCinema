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
    private MovieState state = MovieState.NOT_EXHIBITED;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MovieType type = MovieType.PREVIEW;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKeyColumn(name = "publicIdImage")
    @Column(name = "imageURL")
    @CollectionTable(name = "movie_image")
    @NonNull
    private Map<String, String> image = new HashMap<>();

    //RELATIONS------------------------------------------------------
    @ManyToMany(mappedBy = "movies")
    @LazyCollection(LazyCollectionOption.FALSE)
    @NonNull
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    @ToString.Exclude
    private List<Performance> performances = new ArrayList<>();

    //METHODS--------------------------------------------------------
    @Builder
    public Movie(@NonNull String name, @NonNull String trailer, @NonNull String synopsis, @NonNull String cast, @NonNull Map<String, String> image, @NonNull List<Genre> genres) {
        this.name = name;
        this.trailer = trailer;
        this.synopsis = synopsis;
        this.cast = cast;
        this.image = image;
        this.genres = genres;
    }
}
