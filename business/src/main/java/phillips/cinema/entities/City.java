package phillips.cinema.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import phillips.cinema.entities.enums.Department;

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
    @NonNull
    private String cityName;

    @Enumerated(EnumType.STRING)
    @NonNull
    private Department department;

    //RELATIONS------------------------------------------------------
    @OneToMany(mappedBy = "city")
    private List<Theater> theaters = new ArrayList<>();

    @OneToOne(mappedBy = "city")
    private CityAdmin admin;

    //METHODS--------------------------------------------------------
    public City(@NonNull String cityName, @NonNull Department department) {
        this.cityName = cityName;
        this.department = department;
    }
}
