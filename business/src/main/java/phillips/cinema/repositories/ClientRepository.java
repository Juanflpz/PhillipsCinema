package phillips.cinema.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.ClientCoupon;
import phillips.cinema.entities.Purchase;
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
    Client getByEmailAndPassword(String email, String password);

    @Query("select c from Client c where c.state = :state")
    List<Client> getByState(PersonState state, Pageable pageable);

    //@Query("select p from Client cli, in (cli.purchases) p where cli.email = :email")
    //@Query("select p from Purchase p where p.client.email = :email")
    @Query("select c.purchases from Client c where c.email = :email")
    List<Purchase> getPurchasesByEmail(String email);

    @Query("select c from Client cli join cli.coupons c where cli.email = ?1")
    List<ClientCoupon> getCouponsByEmail(String email);

    @Query("select p from Client c join c.purchases p")
    List<Purchase> getAllPurchases();

    @Query("select c.fullName, c.email, p from Client c left join c.purchases p")
    List<Object[]> getAllPurchasesByClient();
}
