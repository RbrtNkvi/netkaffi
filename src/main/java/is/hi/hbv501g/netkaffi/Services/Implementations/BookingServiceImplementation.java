package is.hi.hbv501g.netkaffi.Services.Implementations;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Booking;
import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.Persistence.Repositories.BookingRepository;
import is.hi.hbv501g.netkaffi.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImplementation implements BookingService {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImplementation(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }
    public List<Booking> findAllByUser(User user){
        return bookingRepository.findAllByUser(user);
    }
    public List<Booking> findAllByProduct(Product product){
        return bookingRepository.findAllByProduct(product);
    }
    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }
    public Booking save(Booking booking){
        return bookingRepository.save(booking);
    }
    public void delete(Booking booking){
        bookingRepository.delete(booking);
    }
}
