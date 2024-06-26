package phillips.cinema.entities;

import lombok.*;
import phillips.cinema.entities.enums.CouponState;

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
    private CouponState state = CouponState.AVAILABLE;

    //RELATIONS-----------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Client client;

    @ManyToOne
    @NonNull
    private Coupon coupon;

    @OneToOne(mappedBy = "clientCoupon")
    private Purchase purchase;

    //METHODS--------------------------------------------------------------------------------------
    @Builder
    public ClientCoupon(@NonNull Client client, @NonNull Coupon coupon) {
        this.client = client;
        this.coupon = coupon;
    }
}
