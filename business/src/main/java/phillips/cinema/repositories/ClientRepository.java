package phillips.cinema.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.enums.PersonState;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    //similar to *
    //@Query("select c from Client c where c.email = :email")
    @Query("select c from Client c where c.email = ?1")
    Client findByEmail(String email);

    @Query("select c from Client c where c.email = :email and c.password = :password")
    Client verifyAuth(String email, String password);

    //it infers the query
    Client findByEmailAndPassword(String email, String password);

    @Query("select c from Client c where c.state = :state")
    List<Client> getByState(PersonState state, Pageable pageable);
}
