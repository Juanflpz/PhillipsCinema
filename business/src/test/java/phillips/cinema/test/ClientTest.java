package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
    public void register(){
        Client client1 = new Client("1", "Juan Felipe Lopez", "juanfelipelopez55@gmail.com", "1234");
        Client client2 = clientRepository.save(client1);
        Assertions.assertEquals("juanfelipelopez55@gmail.com", client2.getEmail());
    }

    @Test
    public void delete(){
        Client client1 = new Client("1", "Juan Felipe Lopez", "juanfelipelopez55@gmail.com", "1234");
        client1.setId_card("1");
        Client client2 = clientRepository.save(client1);
        clientRepository.delete(client2);

        Optional<Client> saved = clientRepository.findById("1");

        Assertions.assertNull(saved.orElse(null));
    }

    @Test
    public void update(){
        Client client1 = new Client("1", "Juan Felipe Lopez", "juanfelipelopez55@gmail.com", "1234");
        client1.setId_card("1");
        Client client2 = clientRepository.save(client1);

        client2.setEmail("juanf.lpezc@uqvirtual.edu.co");

        Client client3 = clientRepository.save(client2);

        Assertions.assertEquals("juanf.lpezc@uqvirtual.edu.co", client3.getEmail());
    }

    @Test
    public void getById(){
        Client client1 = new Client("1", "Juan Felipe Lopez", "juanfelipelopez55@gmail.com", "1234");
        clientRepository.save(client1);
        Optional<Client> saved = clientRepository.findById("1");
        System.out.println(saved.orElse(null));
        Assertions.assertNotNull(saved.orElse(null));
    }

    @Test
    public void list(){
        Client client1 = new Client("1", "Juan Felipe Lopez", "juanfelipelopez55@gmail.com", "1234");
        clientRepository.save(client1);

        Client client2 = new Client("2", "Juan Felipe Lopez", "juanfelipelopez5@gmail.com", "1234");
        clientRepository.save(client2);

        List<Client> saved = clientRepository.findAll();

        System.out.println(saved);
    }
}
