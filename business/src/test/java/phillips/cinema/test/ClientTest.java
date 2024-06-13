package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.enums.PersonState;
import phillips.cinema.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

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
        Client saved = clientRepository.findByEmail("laura.martinez@example.com");
        System.out.println(saved);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verifyAuth(){
        Client saved = clientRepository.findByEmailAndPassword("laura.martinez@example.com", "password345");
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
        List<Client> saved = clientRepository.getByState(PersonState.ACTIVE, PageRequest.of(0, 2));
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


}
