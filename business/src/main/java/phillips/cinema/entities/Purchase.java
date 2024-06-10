package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime purchaseDate;

    //RELATIONS------------------------------------------------------
    @ManyToOne
    @NonNull
    private Client client;

    @OneToOne
    private ClientCoupon clientCoupon;

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

    public Purchase(@NonNull Float total, @NonNull Client client, ClientCoupon clientCoupon, @NonNull PaymentMethod paymentMethod, @NonNull List<Ticket> tickets, List<PurchaseFood> purchaseFoods, @NonNull Performance performance) {
        this.total = total;
        this.client = client;
        this.clientCoupon = clientCoupon;
        this.paymentMethod = paymentMethod;
        this.tickets = tickets;
        this.purchaseFoods = purchaseFoods;
        this.performance = performance;
        this.purchaseDate = LocalDateTime.now();
    }
}
