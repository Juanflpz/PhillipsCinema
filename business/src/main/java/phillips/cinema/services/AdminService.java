package phillips.cinema.services;

import phillips.cinema.entities.CityAdmin;
import phillips.cinema.entities.Client;
import phillips.cinema.entities.Purchase;

import java.util.List;

public interface AdminService {
    CityAdmin login(String email, String password);

    CityAdmin register(String idCard, String fullName, String email, String newPassword, String cityID, String image);

    CityAdmin updateAdmin(CityAdmin client);

    void deleteAdmin(String idCard);

    List<CityAdmin> getAllAdmins();
}
