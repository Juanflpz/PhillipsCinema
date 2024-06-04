package phillips.cinema.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Coupon implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //RELATIONS------------------------------------------------------

    //METHODS--------------------------------------------------------
}
