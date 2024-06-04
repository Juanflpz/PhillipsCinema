package phillips.cinema.entity;

import lombok.*;
import phillips.cinema.entities.Autor;
import phillips.cinema.entities.Genero;
import phillips.cinema.entities.Prestamo;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Coupon implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer id;

    //@Column(length = 60, nullable = false, unique = true)
    @Column(length = 60, nullable = false)
    private String name;

    @Positive
    @Column(nullable = false)
    private Double discount;

    @Column(nullable = false)
    private LocalDate expireDate;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private CouponType type;
}
