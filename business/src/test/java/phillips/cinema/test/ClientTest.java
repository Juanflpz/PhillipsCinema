package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.DTO.PurchaseDTO;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.ClientCoupon;
import phillips.cinema.entities.Purchase;
import phillips.cinema.entities.enums.CouponState;
import phillips.cinema.entities.enums.PersonState;
import phillips.cinema.repositories.ClientRepository;

import java.util.List;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientTest {

    @Autowired //automatically load without instantiating it
    private ClientRepository clientRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Client client1 = new Client("1", "Juan Felipe Lopez", "juanfelipelopez55@gmail.com", "1234");
        Client client2 = clientRepository.save(client1);
        Assertions.assertEquals("juanfelipelopez55@gmail.com", client2.getEmail());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Client saved = clientRepository.findById("1234567890").orElse(null);
        clientRepository.delete(saved);

        Assertions.assertNull(clientRepository.findById("1234567890").orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Client saved = clientRepository.findById("1234567890").orElse(null);
        saved.setEmail("juanf.lpezc@uqvirtual.edu.co");
        Client client = clientRepository.save(saved);

        Assertions.assertEquals("juanf.lpezc@uqvirtual.edu.co", client.getEmail());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Client saved = clientRepository.findById("1234567890").orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getByEmail(){
        Client saved = clientRepository.findClientByEmail("laura.martinez@example.com");
        System.out.println(saved);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verifyAuth(){
        //Client saved = clientRepository.verifyAuth("laura.martinez@example.com", "password345");
        Client saved = clientRepository.findClientByEmailAndPassword("laura.martinez@example.com", "password345");
        System.out.println(saved);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Client> saved = clientRepository.findAll();
        System.out.println(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void pager(){
        List<Client> saved = clientRepository.findAll(PageRequest.of(0, 2)).toList();
        saved.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void statePager(){
        List<Client> saved = clientRepository.findClientByState(PersonState.ACTIVE, PageRequest.of(0, 2));
        saved.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void sortData(){
        List<Client> saved = clientRepository.findAll(Sort.by("fullName"));
        System.out.println(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void sortPager(){
        List<Client> saved = clientRepository.findAll(PageRequest.of(0, 2, Sort.by("fullName", "idCard")) ).toList();
        System.out.println(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findPurchaseByEmail(){
        List<Purchase> purchases = clientRepository.findPurchasesByEmail("laura.martinez@example.com");
        purchases.forEach(System.out::println);
        Assertions.assertNotNull(purchases);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void findCouponsByEmail(){
        List<ClientCoupon> coupons = clientRepository.findCouponsByEmail("laura.martinez@example.com");
        coupons.forEach(System.out::println);
        Assertions.assertNotNull(coupons);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getAllPurchases(){
        List<Purchase> purchases = clientRepository.findAllPurchases();
        purchases.forEach(System.out::println);
        Assertions.assertNotNull(purchases);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getAllPurchasesByClient(){
        List<Object[]> purchases = clientRepository.findAllPurchasesByClient();
        purchases.forEach( o ->
                System.out.println(o[0] + ", " + o[1] + ", " + o[2])
        );
        Assertions.assertNotNull(purchases);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void countRedeemedCoupons(){
        List<Object[]> coupons = clientRepository.countRedeemedCoupons(CouponState.REDEEMED);
        coupons.forEach( o ->
                System.out.println(o[0] + ", " + o[1] + ", " + o[2])
        );
        Assertions.assertNotNull(coupons);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void totalSpent(){
        String idCard = "1234567890";
        Float total = clientRepository.totalSpent(idCard);
        System.out.println("The client with ID card " + idCard + " has spent a total of " + total + " on all their purchases");
        Assertions.assertNotNull(total);
    }

    //NOT USING DTO
    @Test
    @Sql("classpath:dataset.sql")
    public void listPurchasesByClient(){
        List<Object[]> purchases = clientRepository.listPurchasesByClient("1000000001");
        purchases.forEach( o ->
                System.out.println(o[0] + ", " + o[1] + ", " + o[2] + ", " + o[3] + ", " + o[4])
        );
        Assertions.assertNotNull(purchases);
    }

    //DTO
    @Test
    @Sql("classpath:dataset.sql")
    public void listPurchasesByClient1(){
        List<PurchaseDTO> purchases = clientRepository.listPurchasesByClient1("1234567890");
        purchases.forEach(System.out::println);
        Assertions.assertNotNull(purchases);
    }
}
