package phillips.cinema.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import phillips.cinema.entities.Coupon;
import phillips.cinema.entities.enums.CouponType;
import phillips.cinema.repositories.CouponRepository;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest //doesn´t alterate the data
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CouponTest {

    @Autowired
    private CouponRepository couponRepository;

    @Test
    @Sql("classpath:dataset.sql")
    public void register(){
        Coupon coupon = new Coupon("SUMMER_SALE", 0.20, LocalDate.of(2024, 8, 31), "Get 20% off your entire summer wardrobe!", CouponType.AUGUST20);
        Coupon saved = couponRepository.save(coupon);

        Assertions.assertEquals("SUMMER_SALE", saved.getName());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void delete(){
        Coupon saved = couponRepository.findById(1).orElse(null);
        couponRepository.delete(saved);

        Assertions.assertNull(couponRepository.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void update(){
        Coupon saved = couponRepository.findById(1).orElse(null);
        saved.setId(6);
        Coupon coupon = couponRepository.save(saved);

        Assertions.assertEquals(6, coupon.getId());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void getById(){
        Coupon saved = couponRepository.findById(1).orElse(null);
        Assertions.assertNotNull(saved);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void list(){
        List<Coupon> saved = couponRepository.findAll();
        System.out.println(saved);
    }
}
