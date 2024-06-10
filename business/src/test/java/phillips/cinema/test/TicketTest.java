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

    @Test
    @Sql("classpath:dataset.sql")
    public void delete() {
        Ticket saved = ticketRepository.findById(1).orElse(null);
        ticketRepository.delete(saved);

        Assertions.assertNull(ticketRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update() {
        Ticket saved = ticketRepository.findById(1).orElse(null);
        saved.setPillar(8);
        Ticket saved1 = ticketRepository.save(saved);

        Assertions.assertEquals(8, saved1.getPillar());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById() {
        Ticket saved = ticketRepository.findById(3).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list() {
        List<Ticket> tickets = ticketRepository.findAll();
        System.out.println(tickets);
    }
}
