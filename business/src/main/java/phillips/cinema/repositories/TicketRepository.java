package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
