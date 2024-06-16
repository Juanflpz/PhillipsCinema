package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.*;
import phillips.cinema.repositories.PurchaseRepository;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PurchaseTest {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Performance performance = new Performance();
        List<Ticket> tickets = new ArrayList<>();
        List<PurchaseFood> purchaseFoods = new ArrayList<>();
        PaymentMethod paymentMethod = new PaymentMethod();
        ClientCoupon clientCoupon = new ClientCoupon();
        Client client = new Client();
        Purchase purchase = new Purchase(4.8f, client, clientCoupon, paymentMethod, tickets, purchaseFoods, performance);
        Purchase saved = purchaseRepository.save(purchase);

        Assertions.assertEquals(4.8f, saved.getTotal());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Purchase saved = purchaseRepository.findById(1).orElse(null);
        purchaseRepository.delete(saved);

        Assertions.assertNull(purchaseRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Purchase saved = purchaseRepository.findById(1).orElse(null);
        saved.setTotal(100f);
        Purchase purchase = purchaseRepository.save(saved);

        Assertions.assertEquals(100f, purchase.getTotal());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Purchase saved = purchaseRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Purchase> saved = purchaseRepository.findAll();
        System.out.println(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getTicketsByPurchase(){
        List<Ticket> tickets = purchaseRepository.getTicketsByPurchase(2);
        tickets.forEach(System.out::println);
        Assertions.assertEquals(2, tickets.size());
    }
}
