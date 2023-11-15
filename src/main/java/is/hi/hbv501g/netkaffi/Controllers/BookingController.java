package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Booking;
import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.Services.BookingService;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import is.hi.hbv501g.netkaffi.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class BookingController {
    BookingService bookingService;
    ProductService productService;

    public BookingController(BookingService bookingService, ProductService productService){
        this.bookingService = bookingService;
        this.productService = productService;
    }

    @RequestMapping(value="/book/{product}", method = RequestMethod.GET)
    public String productGet(@PathVariable String product, Model model, HttpSession session){
        Product p = productService.findByName(product);
        User user = (User) session.getAttribute("LoggedInUser");
        model.addAttribute("product", p);
        model.addAttribute("activeUser", user);
        return "booking";
    }

    @RequestMapping(value="/book/{product}", method = RequestMethod.POST)
    public String bookingPost(@PathVariable String product, @RequestParam String starthour, @RequestParam Date startdate, Model model, HttpSession session){
        Product p = productService.findByName(product);
        User user = (User) session.getAttribute("LoggedInUser");
        int st = Integer.parseInt(starthour);
        long timestamp = startdate.getTime();
        timestamp += 3600000*st;
        if (bookingService.findByProductAndStarttime(p,timestamp) != null) {
            return "redirect:/book/" + product;
        }
        Booking b = new Booking(user,p,timestamp);
        Booking exists = bookingService.save(b);
        if(exists != null){
            return "redirect:/booked";
        }
        return "redirect:/book/" + product;
    }
}
