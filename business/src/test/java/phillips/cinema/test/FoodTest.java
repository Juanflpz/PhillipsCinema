package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.Food;
import phillips.cinema.entities.enums.FoodState;
import phillips.cinema.entities.enums.FoodType;
import phillips.cinema.repositories.FoodRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FoodTest {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Map<String, String> image = new HashMap<>();
        Food food = new Food(FoodType.FAST_FOOD, FoodState.AVAILABLE, "Fried potatoes", "fried potatoes straight from the kitchen to your seat", image, 500);
        Food saved = foodRepository.save(food);

        Assertions.assertEquals("Fried potatoes", saved.getName());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Food saved = foodRepository.findById(1).orElse(null);
        foodRepository.delete(saved);

        Assertions.assertNull(foodRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Food saved = foodRepository.findById(1).orElse(null);
        saved.setId(6);
        Food food = foodRepository.save(saved);

        Assertions.assertEquals(6, food.getId());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Food saved = foodRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Food> saved = foodRepository.findAll();
        System.out.println(saved);
    }
}
