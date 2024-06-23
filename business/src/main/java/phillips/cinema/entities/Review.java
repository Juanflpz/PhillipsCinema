package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime reviewDate;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    @NonNull
    @ToString.Exclude
    private Client client;

    @ManyToOne
    @NonNull
    @ToString.Exclude
    private Movie movie;

    //METHODS--------------------------------------------------------
    @Builder
    public Review(@NonNull String description, @NonNull Float rate, @NonNull Client client, @NonNull Movie movie) {
        this.description = description;
        this.rate = rate;
        this.reviewDate = LocalDateTime.now();
        this.client = client;
        this.movie = movie;
    }
}
