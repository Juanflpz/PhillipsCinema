package phillips.cinema.services;

import org.springframework.stereotype.Service;
import phillips.cinema.entities.*;
import phillips.cinema.repositories.*;

import java.util.List;
import java.util.Optional;

@Service
public class AdminCinemaServiceImplementation implements AdminCinemaService {

    private final CityRepository cityRepository;
    private final CityAdminRepository adminRepository;
    private final MovieRepository movieRepository;
    private final FoodRepository foodRepository;
    private final CouponRepository couponRepository;
    private final GenreRepository genreRepository;

    public AdminCinemaServiceImplementation(CityRepository cityRepository, CityAdminRepository adminRepository, MovieRepository movieRepository, FoodRepository foodRepository, CouponRepository couponRepository, GenreRepository genreRepository) {
        this.cityRepository = cityRepository;
        this.adminRepository = adminRepository;
        this.movieRepository = movieRepository;
        this.foodRepository = foodRepository;
        this.couponRepository = couponRepository;
        this.genreRepository = genreRepository;
    }

    //Admin methods --------------------------------------------------------------------------------------

    @Override
    public CityAdmin login(String email, String password) throws Exception {
        return null;
    }

    @Override
    public CityAdmin register(CityAdmin cityAdmin) throws Exception {
        return null;
    }

    @Override
    public CityAdmin updateAdmin(CityAdmin admin) throws Exception {
        return null;
    }

    @Override
    public void deleteAdmin(String idCard) throws Exception {

    }

    @Override
    public List<CityAdmin> getAllAdmins() throws Exception {
        return List.of();
    }

    @Override
    public CityAdmin getAdmin(String idCard) throws Exception {
        return null;
    }

    //Movie methods ---------------------------------------------------------------------------------------
    @Override
    public Movie getMovie(Integer idCard) throws Exception {
        return null;
    }

    @Override
    public Movie deleteMovie(Integer idCard) throws Exception {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) throws Exception {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() throws Exception {
        return List.of();
    }

    @Override
    public Movie createMovie(Movie movie) throws Exception {
        return null;
    }

    //Food methods ---------------------------------------------------------------------------------------

    @Override
    public Food getFood(Integer id) throws Exception {
        return null;
    }

    @Override
    public Food deleteFood(Integer id) throws Exception {
        return null;
    }

    @Override
    public Food updateFood(Food newFood) throws Exception {
        return null;
    }

    @Override
    public List<Food> getAllFoods() throws Exception {
        return List.of();
    }

    @Override
    public Food createFood(Food newFood) throws Exception {
        return null;
    }

    //Coupon methods -------------------------------------------------------------------------------------

    @Override
    public Coupon getCoupon(Integer id) throws Exception {
        return null;
    }

    @Override
    public Coupon deleteCoupon(Integer id) throws Exception {
        return null;
    }

    @Override
    public Coupon updateCoupon(Coupon newCoupon) throws Exception {
        return null;
    }

    @Override
    public List<Coupon> getAllCoupons() throws Exception {
        return List.of();
    }

    @Override
    public Coupon createCoupon(Coupon newCoupon) throws Exception {
        return null;
    }

    //City methods ----------------------------------------------------------------------------------------

    @Override
    public City getCity(Integer id) throws Exception {
        Optional<City> city = cityRepository.findById(id);
        if(city.isEmpty()){
            throw new Exception("City not found");
        }

        return city.get();
    }

    @Override
    public City deleteCity(Integer id) throws Exception {
        return null;
    }

    @Override
    public City updateCity(City newCity) throws Exception {
        return null;
    }

    @Override
    public List<City> getAllCities() throws Exception {
        return cityRepository.findAll();
    }

    @Override
    public City createCity(City newCity) throws Exception {
        return cityRepository.save(newCity);
    }

    //Genre methods --------------------------------------------------------------------------------------

    @Override
    public Genre getGenre(Integer id) throws Exception {
        return null;
    }

    @Override
    public Genre deleteGenre(Integer id) throws Exception {
        return null;
    }

    @Override
    public Genre updateGenre(Genre newGenre) throws Exception {
        return null;
    }

    @Override
    public List<Genre> getAllGenres() throws Exception {
        return List.of();
    }

    @Override
    public Genre createGenre(Genre newGenre) throws Exception {
        return null;
    }
}
