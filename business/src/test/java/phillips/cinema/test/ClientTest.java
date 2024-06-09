package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.Client;
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
    public void list(){
        List<Client> saved = clientRepository.findAll();
        System.out.println(saved);
    }
}
