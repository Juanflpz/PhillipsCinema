package phillips.cinema.services;

import phillips.cinema.entities.*;
import phillips.cinema.entities.enums.CouponType;
import phillips.cinema.entities.enums.MovieState;
import phillips.cinema.entities.enums.MovieType;

import java.time.LocalDateTime;
import java.util.List;

public interface ClientService {

    Client login(String email, String password) throws Exception;

    Client register(Client client) throws Exception;

    Client updateClient(Client client) throws Exception;

    Client getClient(String idCard) throws Exception;

    void deleteClient(String idCard) throws Exception;

    List<Client> getAllClients() throws Exception;

    List<Purchase> getAllPurchases(Integer idCard) throws Exception;

    Boolean redeemCoupon(Integer idCard, Integer couponId) throws Exception;

    Client activateAccount(String idCard, LocalDateTime localDateTime) throws Exception;

    Purchase registerPurchase(Purchase purchase) throws Exception;

    List<Movie> getMoviesByCity(String searchString, Integer cityID) throws Exception;

    void sendChangePasswordEmail(String email) throws Exception;

    //was String the localDateTime before
    void changePassword(String email, LocalDateTime localDateTime, String newPassword) throws Exception;

    List<City> getCities();

    City getCity(Integer id) throws Exception;

    List<Ticket> getTicketsByPerformance(Performance performance) throws Exception;

    Purchase getPurchase(Integer id) throws Exception;

    Boolean isCouponAvailable(Coupon coupon) throws Exception;

    List<Performance> getPerformancesMovieCityTheater(Integer movieID, Integer cityID, Integer TheaterID) throws Exception;

    List<Performance> getPerformancesMovieCity(Integer movieID, Integer cityID) throws Exception;

    List<Movie> filterMoviesByTypeCity(Integer stateID, MovieType movieType) throws Exception;

    ClientCoupon addCoupon(Integer couponID, Integer clientID) throws Exception;

    ClientCoupon updateCoupon(ClientCoupon clientCoupon) throws Exception;

    List<ClientCoupon> getClientCoupons(Integer clientID) throws Exception;

    List<ClientCoupon> getClientCouponsByState(Integer clientID, CouponType state) throws Exception;

    Review createReview(Review review) throws Exception;

    Review updateReview(Review review) throws Exception;

    Review getReview(Integer id) throws Exception;

    Review deleteReview(Integer id) throws Exception;

    List<Review> getReviewsByClient(Integer clientID) throws Exception;

    List<Review> getReviews() throws Exception;

    PhoneNumber addPhoneNumber(PhoneNumber phoneNumber) throws Exception;

    /*
    CuponCliente obtenerCuponCliente(Integer idCuponCliente) throws Exception;

    void agregarCuponCorreo(String nombreCupon, String emailCliente) throws Exception;
    */
}
