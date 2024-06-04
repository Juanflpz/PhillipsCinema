package phillips.cinema.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket implements Serializable {
    // Atributos -----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private TicketState state;

    @Column(nullable = false)
    private Integer row;

    @Column(nullable = false)
    private Integer column;
}
