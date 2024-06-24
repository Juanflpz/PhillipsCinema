package phillips.cinema.services;

import phillips.cinema.entities.*;

import java.util.List;

public interface AdminCinemaService {

    CityAdmin login(String email, String password) throws Exception;

    CityAdmin register(CityAdmin cityAdmin) throws Exception;

    CityAdmin updateAdmin(CityAdmin admin) throws Exception;

    void deleteAdmin(String idCard) throws Exception;

    List<CityAdmin> getAllAdmins() throws Exception;

    CityAdmin getAdmin(String idCard) throws Exception;

    Movie getMovie(Integer idCard) throws Exception;

    Movie deleteMovie(Integer idCard) throws Exception;

    Movie updateMovie(Movie movie) throws Exception;

    List<Movie> getAllMovies() throws Exception;

    Movie createMovie(Movie movie) throws Exception;

    Food getFood(Integer id) throws Exception;

    Food deleteFood(Integer id) throws Exception;

    Food updateFood(Food newFood) throws Exception;

    List<Food> getAllFoods() throws Exception;

    Food createFood(Food newFood) throws Exception;

    Coupon getCoupon(Integer id) throws Exception;

    Coupon deleteCoupon(Integer id) throws Exception;

    Coupon updateCoupon(Coupon newCoupon) throws Exception;

    List<Coupon> getAllCoupons() throws Exception;

    Coupon createCoupon(Coupon newCoupon) throws Exception;

    City getCity(Integer id) throws Exception;

    City deleteCity(Integer id) throws Exception;

    City updateCity(City newCity) throws Exception;

    List<City> getAllCities() throws Exception;

    City createCity(City newCity) throws Exception;

    Genre getGenre(Integer id) throws Exception;

    Genre deleteGenre(Integer id) throws Exception;

    Genre updateGenre(Genre newGenre) throws Exception;

    List<Genre> getAllGenres() throws Exception;

    Genre createGenre(Genre newGenre) throws Exception;

    PaymentMethod getPaymentMethod(Integer id) throws Exception;

    PaymentMethod deletePaymentMethod(Integer id) throws Exception;

    PaymentMethod updatePaymentMethod(PaymentMethod newPaymentMethod) throws Exception;

    List<PaymentMethod> getAllPaymentMethods() throws Exception;

    PaymentMethod createPaymentMethod(PaymentMethod newPaymentMethod) throws Exception;


}
