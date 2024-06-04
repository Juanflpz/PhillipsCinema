package phillips.cinema.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Food implements Serializable {
    //ATTRIBUTES-----------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private FoodType type;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private FoodState state;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer amount;

    @Column(length = 200, nullable = false)
    private String description;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKeyColumn(name = "publicIdImage")
    @Column(name = "imageURL")
    @CollectionTable(name = "food_image")
    private Map<String, String> image = new HashMap<>();

    //RELATIONS------------------------------------------------------
    @OneToMany(mappedBy = "food")
    private List<PurchaseFood> purchaseFoods = new ArrayList<>();

    //METHODS--------------------------------------------------------
}
