package phillips.cinema.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import phillips.cinema.repositories.ClientRepository;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientTest {

    @Autowired //automatically load without instantiating it
    private ClientRepository clientRepository;

    public void register(){

    }

    public void delete(){

    }

    public void upload(){

    }

    public void getById(){

    }

    public void list(){

    }
}
