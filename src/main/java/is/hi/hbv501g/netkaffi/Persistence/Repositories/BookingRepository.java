package is.hi.hbv501g.netkaffi.Persistence.Repositories;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Booking;
import is.hi.hbv501g.netkaffi.Persistence.Entities.BookingId;
import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, BookingId> {
    List<Booking> findAllByUser(User user);
    List<Booking> findAllByProduct(Product product);
    List<Booking> findAll();
    Booking save(Booking booking);
    void delete(Booking booking);
    Booking findByProductAndStarttime(Product product, long starttime);
}
