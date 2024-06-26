package phillips.cinema.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PurchaseFood implements Serializable {
    //ATTRIBUTES-----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private Float price;

    @Column(nullable = false)
    @NonNull
    private Integer purchasedUnits;

    //RELATIONS------------------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Purchase purchase;

    @ManyToOne
    @NonNull
    private Food food;

    //METHODS-----------------------------------------------------------------------------------
    @Builder
    public PurchaseFood(@NonNull Float price, @NonNull Integer purchasedUnits, @NonNull Purchase purchase, @NonNull Food food) {
        this.price = price;
        this.purchasedUnits = purchasedUnits;
        this.purchase = purchase;
        this.food = food;
    }
}
