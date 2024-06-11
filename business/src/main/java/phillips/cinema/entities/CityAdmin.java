package phillips.cinema.entities;

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
@ToString(callSuper = true)
public class CityAdmin extends Person implements Serializable {
    //ATTRIBUTES------------------------------------------------------
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE) //la colección debe ser cargada de forma inmediata (no perezosa).
    @MapKeyColumn(name = "publicIdImage")
    @Column(name = "imageURL")
    @CollectionTable(name = "admin_image")
    private Map<String, String> profileImage = new HashMap<>();

    //RELATIONS------------------------------------------------------
    @OneToOne
    @NonNull
    private City city;

    @ToString.Exclude
    @OneToMany(mappedBy = "admin")
    private List<Theater> theaters = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "admin")
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    //METHODS--------------------------------------------------------
    public CityAdmin(String id_card, String fullName, String email, String password, Map<String, String> profileImage, @NonNull City city) {
        super(id_card, fullName, email, password);
        this.profileImage = profileImage;
        this.city = city;
    }
}
