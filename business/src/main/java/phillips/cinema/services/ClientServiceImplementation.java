package phillips.cinema.services;

import org.springframework.stereotype.Service;
import phillips.cinema.entities.*;
import phillips.cinema.entities.enums.CouponType;
import phillips.cinema.entities.enums.MovieType;
import phillips.cinema.repositories.ClientCouponRepository;
import phillips.cinema.repositories.ClientRepository;
import phillips.cinema.repositories.PurchaseRepository;
import phillips.cinema.repositories.ReviewRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplementation implements ClientService {

    private final ClientRepository clientRepository;
    private final ReviewRepository reviewRepository;
    private final PurchaseRepository purchaseRepository;
    private final ClientCouponRepository clientCouponRepository;

    public ClientServiceImplementation(ClientRepository clientRepository, ReviewRepository reviewRepository, PurchaseRepository purchaseRepository, ClientCouponRepository clientCouponRepository) {
        this.clientRepository = clientRepository;
        this.reviewRepository = reviewRepository;
        this.purchaseRepository = purchaseRepository;
        this.clientCouponRepository = clientCouponRepository;
    }

    @Override
    public Client login(String email, String password) throws Exception {
        Client client = clientRepository.findClientByEmailAndPassword(email, password);
        if(client == null) {
            throw new Exception("Invalid email or password");
        }
        return client;
    }

    @Override
    public Client register(Client client) throws Exception {

        Boolean verification = verifyEmail(client.getEmail());

        if(!verification) {
            throw new Exception("Email already in use");
        }

        return clientRepository.save(client);
    }

    //if equals to null the client doesnt exist, otherwise not
    private Boolean verifyEmail(String email) {
        return clientRepository.findClientByEmail(email).orElse(null) == null;
    }

    @Override
    public Client updateClient(Client client) throws Exception {
        Optional<Client> saved = clientRepository.findById(client.getIdCard());

        if(saved.isEmpty()){
            throw new Exception("Client not found");
        }
        //if the client is already registered it updates him
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(String idCard) throws Exception {
        Optional<Client> saved = clientRepository.findById(idCard);

        if(saved.isEmpty()){
            throw new Exception("Client not found");
        }

        return saved.get();
    }

    @Override
    public void deleteClient(String idCard) throws Exception {
        Optional<Client> saved = clientRepository.findById(idCard);

        if(saved.isEmpty()){
            throw new Exception("Client not found");
        }

        clientRepository.delete(saved.get());
    }

    @Override
    public List<Client> getAllClients() throws Exception {
        return clientRepository.findAll();
    }

    @Override
    public List<Purchase> getAllPurchases(Integer idCard) throws Exception {
        return List.of();
    }

    @Override
    public Boolean redeemCoupon(Integer idCard, Integer couponId) throws Exception {
        return null;
    }

    @Override
    public Client activateAccount(String idCard, LocalDateTime localDateTime) throws Exception {
        return null;
    }

    @Override
    public Purchase registerPurchase(Purchase purchase) throws Exception {
        return null;
    }

    @Override
    public List<Movie> getMoviesByCity(String searchString, Integer cityID) throws Exception {
        return List.of();
    }

    @Override
    public void sendChangePasswordEmail(String email) throws Exception {

    }

    @Override
    public void changePassword(String email, LocalDateTime localDateTime, String newPassword) throws Exception {

    }

    @Override
    public List<City> getCities() {
        return List.of();
    }

    @Override
    public City getCity(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Ticket> getTicketsByPerformance(Performance performance) throws Exception {
        return List.of();
    }

    @Override
    public Purchase getPurchase(Integer id) throws Exception {
        return null;
    }

    @Override
    public Boolean isCouponAvailable(Coupon coupon) throws Exception {
        return null;
    }

    @Override
    public List<Performance> getPerformancesMovieCityTheater(Integer movieID, Integer cityID, Integer TheaterID) throws Exception {
        return List.of();
    }

    @Override
    public List<Performance> getPerformancesMovieCity(Integer movieID, Integer cityID) throws Exception {
        return List.of();
    }

    @Override
    public List<Movie> filterMoviesByTypeCity(Integer stateID, MovieType movieType) throws Exception {
        return List.of();
    }

    @Override
    public ClientCoupon addCoupon(Integer couponID, Integer clientID) throws Exception {
        return null;
    }

    @Override
    public ClientCoupon updateCoupon(ClientCoupon clientCoupon) throws Exception {
        return null;
    }

    @Override
    public List<ClientCoupon> getClientCoupons(Integer clientID) throws Exception {
        return List.of();
    }

    @Override
    public List<ClientCoupon> getClientCouponsByState(Integer clientID, CouponType state) throws Exception {
        return List.of();
    }

    @Override
    public Review createReview(Review review) throws Exception {
        return null;
    }

    @Override
    public Review updateReview(Review review) throws Exception {
        return null;
    }

    @Override
    public Review getReview(Integer id) throws Exception {
        return null;
    }

    @Override
    public Review deleteReview(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Review> getReviewsByClient(Integer clientID) throws Exception {
        return List.of();
    }

    @Override
    public List<Review> getReviews() throws Exception {
        return List.of();
    }

    @Override
    public PhoneNumber addPhoneNumber(PhoneNumber phoneNumber) throws Exception {
        return null;
    }
}
