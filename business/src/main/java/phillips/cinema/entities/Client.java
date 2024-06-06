package phillips.cinema.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Client extends Person implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE) //la colección debe ser cargada de forma inmediata (no perezosa).
    @MapKeyColumn(name = "publicIdImage")
    @Column(name = "imageURL")
    @CollectionTable(name = "client_image")
    private Map<String, String> profileImage = new HashMap<>();

    @ElementCollection
    @Column(name = "year")
    private List<Integer> celebratedYears = new ArrayList<>();

    @Positive
    @Column(nullable = false)
    private Integer level = 1;

    private LocalDate birthDate;

    //RELATIONS------------------------------------------------------
    @OneToMany(mappedBy = "client")
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<ClientCoupon> coupons = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases = new ArrayList<>();
    //METHODS--------------------------------------------------------
}
