package is.hi.hbv501g.netkaffi.Services;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Booking;
import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;

import java.util.List;

public interface BookingService {
    List<Booking> findAllByUser(User user);
    List<Booking> findAllByProduct(Product product);
    List<Booking> findAll();
    Booking save(Booking booking);
    void delete(Booking booking);
    Booking findByProductAndStarttime(Product product, long starttime);
}
