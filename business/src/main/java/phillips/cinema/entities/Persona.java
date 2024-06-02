package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Email
    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @ElementCollection
    private Map<String, String> telefonos;

    @ManyToOne
    private Ciudad ciudad;

    @OneToMany(mappedBy = "persona")
    private List<Prestamo> prestamos;
}
