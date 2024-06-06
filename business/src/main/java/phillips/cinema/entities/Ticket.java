package phillips.cinema.entities;

import lombok.*;
import phillips.cinema.entities.enums.TicketState;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket implements Serializable {
    //ATTRIBUTES-----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private TicketState state = TicketState.AVAILABLE;

    @Column(nullable = false)
    @NonNull
    private Integer stripe;

    @Column(nullable = false)
    @NonNull
    private Integer pillar;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    private Purchase purchase;

    @ManyToOne
    @NonNull
    private MovieTheater movieTheater;

    @ManyToOne
    @NonNull
    private Performance performance;

    //METHODS--------------------------------------------------------
    public Ticket(@NonNull Integer stripe, @NonNull Integer pillar, @NonNull MovieTheater movieTheater, @NonNull Performance performance) {
        this.stripe = stripe;
        this.pillar = pillar;
        this.movieTheater = movieTheater;
        this.performance = performance;
    }
}
