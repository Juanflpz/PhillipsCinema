package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Purchase implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Positive
    @Column(nullable = false)
    @NonNull
    private Float total;

    @Column(length = 100, nullable = false)
    @NonNull
    private String address;

    @Column(nullable = false)
    @NonNull
    private LocalDate purchaseDate;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    private Client client;

    @OneToOne
    private ClientCoupon coupon;

    @ManyToOne
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "purchase")
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseFood> purchaseFoods = new ArrayList<>();

    //METHODS--------------------------------------------------------
}