package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.MovieTheater;
import phillips.cinema.entities.Performance;
import phillips.cinema.entities.Ticket;
import phillips.cinema.repositories.TicketRepository;

import java.util.List;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TicketTest {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register() {
        MovieTheater movieTheater = new MovieTheater();
        Performance performance = new Performance();
        Ticket ticket = new Ticket(5, 7, movieTheater, performance);
        Ticket ticket1 = ticketRepository.save(ticket);
        Assertions.assertEquals(7, ticket1.getPillar());
    }
    /*
    @Test
    @Sql("classpath:dataset.sql")
    public void delete() {
        Client saved = clientRepository.findById("1234567890").orElse(null);
        clientRepository.delete(saved);

        Assertions.assertNull(clientRepository.findById("1234567890").orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update() {
        Client saved = clientRepository.findById("1234567890").orElse(null);
        saved.setEmail("juanf.lpezc@uqvirtual.edu.co");
        Client client = clientRepository.save(saved);

        Assertions.assertEquals("juanf.lpezc@uqvirtual.edu.co", client.getEmail());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById() {
        Client saved = clientRepository.findById("1234567890").orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list() {
        List<Client> saved = clientRepository.findAll();
        System.out.println(saved);
    }
    */
}
