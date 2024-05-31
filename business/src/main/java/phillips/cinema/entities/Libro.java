package phillips.cinema.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Objects;

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
}
