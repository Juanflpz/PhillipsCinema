package phillips.cinema.entities;

import lombok.*;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import phillips.cinema.entities.enums.PersonState;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {
    // Atributos -----------------------------------------------------------------------------------------
    @Id
    @EqualsAndHashCode.Include
    @Length(max = 10)
    @Column(length = 10)
    private String id_card;

    @Length(max = 60)
    @Column(length = 60, nullable = false)
    @NonNull
    private String fullName;

    @Length(max = 50)
    @Email
    @Column(length = 50, nullable = false, unique = true)
    @NonNull
    private String email;

    @ToString.Exclude
    @Column(nullable = false)
    @NonNull
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private PersonState state = PersonState.ACTIVE;

    // Constructor ------------------------------------------------------------------------------------
    public Person(String id_card, String fullName, String email, String password) {
        this.id_card = id_card;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
}
