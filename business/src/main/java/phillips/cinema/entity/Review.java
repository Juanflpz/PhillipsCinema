package phillips.cinema.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Review implements Serializable {
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
}
