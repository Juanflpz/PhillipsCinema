package phillips.cinema.entities;

import lombok.*;
import phillips.cinema.entities.enums.CouponState;
import phillips.cinema.entities.enums.CouponType;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @NonNull
    private String name;

    @Positive
    @Column(nullable = false)
    @NonNull
    private Double discount;

    @Column(nullable = false)
    @NonNull
    private LocalDate expireDate;

    @Column(nullable = false)
    @NonNull
    private String description;

    @Enumerated(EnumType.STRING)
    @NonNull
    private CouponType type;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CouponState state = CouponState.AVAILABLE;

    //RELATIONS------------------------------------------------------
    @OneToMany(mappedBy = "coupon")
    @ToString.Exclude
    private List<ClientCoupon> clientCoupons = new ArrayList<>();

    //METHODS--------------------------------------------------------
    public Coupon(@NonNull String name, @NonNull Double discount, @NonNull LocalDate expireDate, @NonNull String description, @NonNull CouponType type) {
        this.name = name;
        this.discount = discount;
        this.expireDate = expireDate;
        this.description = description;
        this.type = type;
    }
}
