package phillips.cinema.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.ClientCoupon;
import phillips.cinema.entities.Purchase;
import phillips.cinema.entities.enums.CouponState;
import phillips.cinema.entities.enums.PersonState;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    //similar to *
    //@Query("select c from Client c where c.email = :email")
    @Query("select c from Client c where c.email = ?1")
    Client findClientByEmail(String email);

    @Query("select c from Client c where c.email = :email and c.password = :password")
    Client verifyAuth(String email, String password);

    //it infers the query
    Client findClientByEmailAndPassword(String email, String password);

    @Query("select c from Client c where c.state = :state")
    List<Client> findClientByState(PersonState state, Pageable pageable);

    //@Query("select p from Client cli, in (cli.purchases) p where cli.email = :email")
    //@Query("select p from Purchase p where p.client.email = :email")
    @Query("select c.purchases from Client c where c.email = :email")
    List<Purchase> findPurchasesByEmail(String email);

    @Query("select c from Client cli join cli.coupons c where cli.email = ?1")
    List<ClientCoupon> findCouponsByEmail(String email);

    @Query("select p from Client c join c.purchases p")
    List<Purchase> findAllPurchases();

    @Query("select c.fullName, c.email, p from Client c left join c.purchases p")
    List<Object[]> findAllPurchasesByClient();

    @Query("select count(c.id), cli.idCard, cli.fullName from Client cli join ClientCoupon c ON cli.idCard = c.client.idCard WHERE c.state = :state group by cli.idCard order by count(c.id)")
    List<Object[]> countRedeemedCoupons(CouponState state);
}
