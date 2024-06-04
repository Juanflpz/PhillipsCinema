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
public class ClientCoupon implements Serializable {
    // Atributos ------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CouponState estado = CouponState.AVAILABLE;

    // Relaciones -----------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Client client;

    @ManyToOne
    @NonNull
    private Coupon coupon;

    @OneToOne
    private Purchase purchase;
}
