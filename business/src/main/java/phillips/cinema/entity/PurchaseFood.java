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
public class PurchaseFood implements Serializable {
    // Atributos -----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Integer purchasedUnits;

    // Relaciones ------------------------------------------------------------------------------------------
    @ManyToOne
    @NonNull
    private Purchase purchase;

    @ManyToOne
    @NonNull
    private Food food;
}
