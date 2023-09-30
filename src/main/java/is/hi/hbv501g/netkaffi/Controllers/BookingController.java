package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Booking;
import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.Services.BookingService;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import is.hi.hbv501g.netkaffi.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {
    BookingService bookingService;
    ProductService productService;

    public BookingController(BookingService bookingService, ProductService productService){
        this.bookingService = bookingService;
        this.productService = productService;
    }

    @RequestMapping(value="/book/{product}", method = RequestMethod.GET)
    public String productGet(@PathVariable String product, Model model){
        Product p = productService.findByName(product);
        model.addAttribute("product", p);
        return "booking";
    }

    @RequestMapping(value="/book/{product}", method = RequestMethod.POST)
    public String bookingPost(@PathVariable String product, @RequestParam String starttime, Model model, HttpSession session){
        Product p = productService.findByName(product);
        User user = (User) session.getAttribute("LoggedInUser");
        int st = Integer.parseInt(starttime);
        Booking b = new Booking(user,p,st);
        Booking exists = bookingService.save(b);
        if(exists != null){
            return "redirect:/booked";
        }
        return "redirect:/book/" + product;
    }
}
