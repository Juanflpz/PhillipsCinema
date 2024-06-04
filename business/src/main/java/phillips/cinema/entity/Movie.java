package phillips.cinema.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    @MapKeyColumn(name = "publicIdImagen")
    @Column(name = "urlImagen")
    @CollectionTable(name = "pelicula_imagen")
    private Map<String, String> imagen = new HashMap<>();

    @ManyToMany(mappedBy = "movies")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Genre> genres = new ArrayList<>();
}
