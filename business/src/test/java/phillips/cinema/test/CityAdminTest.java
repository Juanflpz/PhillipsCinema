package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.City;
import phillips.cinema.entities.CityAdmin;
import phillips.cinema.entities.Client;
import phillips.cinema.repositories.CityAdminRepository;
import phillips.cinema.repositories.ClientRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CityAdminTest {

    @Autowired //automatically load without instantiating it
    private CityAdminRepository cityAdminRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        City city = new City();
        Map<String, String> map = new HashMap<>();
        map.put("image1", "profilepicture.com/sdahfsahfksajjkfhsdjkfjhsdhjkfsdf");
        CityAdmin admin = new CityAdmin("1234", "Juan López", "phillip@gmail.com", "password", map, city);
        CityAdmin savedAdmin = cityAdminRepository.save(admin);

        Assertions.assertEquals("phillip@gmail.com", savedAdmin.getEmail());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        CityAdmin saved = cityAdminRepository.findById("1234567892").orElse(null);
        cityAdminRepository.delete(saved);

        Assertions.assertNull(cityAdminRepository.findById("1234567892").orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        CityAdmin saved = cityAdminRepository.findById("1234567892").orElse(null);
        saved.setEmail("juanf.lpezc@uqvirtual.edu.co");
        CityAdmin admin = cityAdminRepository.save(saved);

        Assertions.assertEquals("juanf.lpezc@uqvirtual.edu.co", admin.getEmail());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        CityAdmin saved = cityAdminRepository.findById("1234567892").orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<CityAdmin> saved = cityAdminRepository.findAll();
        System.out.println(saved);
    }
}
