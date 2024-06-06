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

    @Lob
    @Column(length = 200, nullable = false)
    @NonNull
    private String description;

    @Column(nullable = false)
    @NonNull
    private Float rate;

    @Column(nullable = false)
    @NonNull
    private LocalDate reviewDate;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    @NonNull
    private Client client;

    @ManyToOne
    @NonNull
    private Movie movie;

    //METHODS--------------------------------------------------------
    public Review(@NonNull String description, @NonNull Float rate, @NonNull LocalDate reviewDate, @NonNull Client client, @NonNull Movie movie) {
        this.description = description;
        this.rate = rate;
        this.reviewDate = reviewDate;
        this.client = client;
        this.movie = movie;
    }
}
