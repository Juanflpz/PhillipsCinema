package phillips.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phillips.cinema.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}
