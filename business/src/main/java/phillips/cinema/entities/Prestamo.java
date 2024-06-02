package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Prestamo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Integer codigo;
    private LocalDateTime fecha_prestamo;
    private LocalDate fecha_devolucion;

    @ManyToOne
    private Persona persona;

    @ManyToMany
    private List<Libro> libros;
}
