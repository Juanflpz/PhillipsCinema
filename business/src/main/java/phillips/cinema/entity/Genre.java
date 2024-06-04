package phillips.cinema.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

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
public class Genre implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    @NonNull
    private String name;

    //RELATIONS------------------------------------------------------
    @ManyToMany
    private List<Movie> movies = new ArrayList<>();

    //METHODS--------------------------------------------------------
}
