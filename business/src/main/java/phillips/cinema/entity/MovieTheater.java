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

    @LazyCollection(LazyCollectionOption.FALSE)
    private List<MovieTheaterType> types = new ArrayList<>();

    //RELATIONS------------------------------------------------------

    //METHODS--------------------------------------------------------
}
