package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Libro implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private String isbn;

    private String titulo;

    @PositiveOrZero
    private int unidades;

    @PositiveOrZero
    private int anio;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @ManyToMany(mappedBy = "libros")
    private List<Prestamo> prestamos;

    @ManyToMany
    private List<Autor> autores;
}
