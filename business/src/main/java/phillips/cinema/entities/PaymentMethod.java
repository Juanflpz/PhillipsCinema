package phillips.cinema.entities;

import lombok.*;

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
public class PaymentMethod implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    @NonNull
    private String name;

    //RELATIONS------------------------------------------------------
    @OneToMany(mappedBy = "paymentMethod")
    private List<Purchase> purchases = new ArrayList<>();

    //METHODS--------------------------------------------------------
    public PaymentMethod(@NonNull String name) {
        this.name = name;
    }
}

/*
CREDIT_CARD,
    DEBIT_CARD,
    APPLE_PAY,
    GOOGLE_PAY
 */
