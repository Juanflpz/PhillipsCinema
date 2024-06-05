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
    private TicketState state;

    @Column(nullable = false)
    private Integer h_line;

    @Column(nullable = false)
    private Integer v_line;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    private Purchase purchase;

    @ManyToOne
    private MovieTheater movieTheater;

    @ManyToOne
    private Performance performance;

    //METHODS--------------------------------------------------------
}
