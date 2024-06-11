package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.City;
import phillips.cinema.entities.CityAdmin;
import phillips.cinema.entities.Schedule;
import phillips.cinema.repositories.ScheduleRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ScheduleTest {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Schedule schedule1 = new Schedule(LocalDate.of(2024, 6, 15), LocalTime.of(10, 30));
        Schedule saved = scheduleRepository.save(schedule1);

        Assertions.assertEquals(LocalDate.of(2024, 6, 15), saved.getDate());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Schedule saved = scheduleRepository.findById(1).orElse(null);
        scheduleRepository.delete(saved);

        Assertions.assertNull(scheduleRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Schedule saved = scheduleRepository.findById(1).orElse(null);
        saved.setId(10);
        Schedule saved1 = scheduleRepository.save(saved);

        Assertions.assertEquals(10, saved1.getId());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Schedule saved = scheduleRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Schedule> saved = scheduleRepository.findAll();
        System.out.println(saved);
    }
}
