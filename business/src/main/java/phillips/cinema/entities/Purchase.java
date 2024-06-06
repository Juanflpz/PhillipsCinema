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

    @Column(nullable = false)
    @NonNull
    private LocalDate purchaseDate;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    @NonNull
    private Client client;

    @OneToOne
    private ClientCoupon coupon;

    @ManyToOne
    @NonNull
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "purchase")
    @NonNull
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseFood> purchaseFoods = new ArrayList<>();

    @ManyToOne
    @NonNull
    private Performance performance;

    //METHODS--------------------------------------------------------
    public Purchase(@NonNull Float total, @NonNull LocalDate purchaseDate, @NonNull Client client, @NonNull PaymentMethod paymentMethod, @NonNull List<Ticket> tickets, @NonNull Performance performance) {
        this.total = total;
        this.purchaseDate = purchaseDate;
        this.client = client;
        this.paymentMethod = paymentMethod;
        this.tickets = tickets;
        this.performance = performance;
    }

}
