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
    // ATTRIBUTES------------------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CouponState estado = CouponState.AVAILABLE;

    //RELATIONS-----------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Client client;

    @ManyToOne
    @NonNull
    private Coupon coupon;

    @OneToOne(mappedBy = "coupon")
    private Purchase purchase;

    //METHODS--------------------------------------------------------------------------------------
}
