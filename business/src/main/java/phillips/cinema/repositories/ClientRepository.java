package phillips.cinema.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phillips.cinema.DTO.PurchaseDTO;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.ClientCoupon;
import phillips.cinema.entities.Purchase;
import phillips.cinema.entities.enums.CouponState;
import phillips.cinema.entities.enums.PersonState;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    @Query("SELECT c FROM Client c WHERE c.email = ?1")
    Optional<Client> findClientByEmail(String email);

    @Query("SELECT c FROM Client c WHERE c.email = :email AND c.password = :password")
    Client verifyAuth(String email, String password);

    //it infers the query
    Client findClientByEmailAndPassword(String email, String password);

    @Query("SELECT c FROM Client c WHERE c.state = :state")
    List<Client> findClientByState(PersonState state, Pageable pageable);

    @Query("SELECT c.purchases FROM Client c WHERE c.email = :email")
    List<Purchase> findPurchasesByEmail(String email);

    @Query("SELECT c FROM Client cli JOIN cli.coupons c WHERE cli.email = ?1")
    List<ClientCoupon> findCouponsByEmail(String email);

    @Query("SELECT p FROM Client c JOIN c.purchases p")
    List<Purchase> findAllPurchases();

    @Query("SELECT c.fullName, c.email, p FROM Client c LEFT JOIN c.purchases p")
    List<Object[]> findAllPurchasesByClient();

    @Query("SELECT count(c.id), cli.idCard, cli.fullName FROM Client cli " +
             "JOIN ClientCoupon c ON cli.idCard = c.client.idCard WHERE c.state = :state " +
             "GROUP BY cli.idCard ORDER BY count(c.id)")
    List<Object[]> countRedeemedCoupons(CouponState state);

    @Query("SELECT sum(p.total) FROM Client c JOIN c.purchases p WHERE p.client.idCard = :idCard")
    Float totalSpent(String idCard);

    @Query("SELECT p.total, p.purchaseDate, perf, " +
            "COALESCE((SELECT SUM(pf.price * pf.purchasedUnits) FROM PurchaseFood pf WHERE pf.purchase = p), 0), " +
            "COALESCE((SELECT SUM(t.performance.price) FROM Ticket t WHERE t.purchase = p), 0)" +
            "FROM Purchase p JOIN p.performance perf WHERE p.client.idCard = :idCard")
    List<Object[]> listPurchasesByClient(String idCard);

    @Query("SELECT NEW phillips.cinema.DTO.PurchaseDTO(p.total, p.purchaseDate, perf, " +
            "COALESCE((SELECT SUM(pf.price * pf.purchasedUnits) FROM PurchaseFood pf WHERE pf.purchase = p), 0), " +
            "COALESCE((SELECT SUM(t.performance.price) FROM Ticket t WHERE t.purchase = p), 0))" +
            "FROM Purchase p JOIN p.performance perf WHERE p.client.idCard = :idCard")
    List<PurchaseDTO> listPurchasesByClient1(String idCard);
}
