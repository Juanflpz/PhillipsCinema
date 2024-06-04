package phillips.cinema.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Positive;
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
    private City city;

    @OneToMany(mappedBy = "admin")
    private List<Theater> theaters = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    //METHODS--------------------------------------------------------
}
