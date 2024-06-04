package phillips.cinema.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Theater implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 50, nullable = false)
    @NonNull
    private String name;

    @Column(length = 50, nullable = false)
    @NonNull
    private String address;
}
