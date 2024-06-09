package phillips.cinema.entities;

import lombok.*;
import phillips.cinema.entities.enums.PhoneType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PhoneNumber implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @EqualsAndHashCode.Include
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private PhoneType type;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    private CityAdmin admin;

    @ManyToOne
    private Client client;

    //METHODS--------------------------------------------------------
    public PhoneNumber(Integer id, @NonNull PhoneType type) {
        this.id = id;
        this.type = type;
    }
}
