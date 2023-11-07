package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Booking;
import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.Services.BookingService;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookedController {

    BookingService bookedService;
    ProductService productService;

    public BookedController(BookingService bookedService, ProductService productService){
        this.bookedService = bookedService;
        this.productService = productService;
    }

    @RequestMapping(value="/booked", method= RequestMethod.GET)
    public String bookedGet(HttpSession session, Model model){
        User user = (User) session.getAttribute("LoggedInUser");
        List<Booking> booked;
        if(user.getIsAdmin()){
            booked = bookedService.findAll();
        } else {
            booked = bookedService.findAllByUser(user);
        }
        model.addAttribute("bookings", booked);
        model.addAttribute("user", user);
        return "booked";
    }

    @RequestMapping(value="/booked", method= RequestMethod.POST)
    public String bookedDelete(@RequestParam String productName,@RequestParam int starttime, Model model){
        Product product = productService.findByName(productName);
        Booking booking = bookedService.findByProductAndStarttime(product,starttime);
        bookedService.delete(booking);
        return "redirect:/booked";
    }
}
