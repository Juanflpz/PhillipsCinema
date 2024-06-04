package phillips.cinema.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import phillips.cinema.entity.enums.Department;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "city")
    private List<Theater> theaters = new ArrayList<>();

    @OneToOne(mappedBy = "city")
    private CityAdmin admin;
    //METHODS--------------------------------------------------------
}
