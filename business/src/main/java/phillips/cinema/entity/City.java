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
public class City implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 30)
    @Column(length = 60, nullable = false)
    private String cityName;

    @Enumerated(EnumType.STRING)
    private Department type;

    //RELATIONS------------------------------------------------------

    //METHODS--------------------------------------------------------
}
