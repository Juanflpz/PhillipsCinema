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
public class PhoneNumber implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;
}
