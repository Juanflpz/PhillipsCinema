package phillips.cinema.entities;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import phillips.cinema.entities.enums.FoodState;
import phillips.cinema.entities.enums.FoodType;

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
    @NonNull
    private FoodType type;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    @NonNull
    private FoodState state;

    @Column(length = 100, nullable = false)
    @NonNull
    private String name;

    @Column(nullable = false)
    private Integer amount;

    @Column(length = 200, nullable = false)
    @NonNull
    private String description;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKeyColumn(name = "publicIdImage")
    @Column(name = "imageURL")
    @CollectionTable(name = "food_image")
    @NonNull
    private Map<String, String> image = new HashMap<>();

    //RELATIONS------------------------------------------------------
    @OneToMany(mappedBy = "food")
    private List<PurchaseFood> purchaseFoods = new ArrayList<>();

    //METHODS--------------------------------------------------------
    public Food(@NonNull FoodType type, @NonNull FoodState state, @NonNull String name, @NonNull String description, @NonNull Map<String, String> image) {
        this.type = type;
        this.state = state;
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
