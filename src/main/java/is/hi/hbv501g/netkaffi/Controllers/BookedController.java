package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Booking;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.Services.BookingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookedController {

    BookingService bookedService;

    public BookedController(BookingService bookedService){
        this.bookedService = bookedService;
    }

    @RequestMapping(value="/booked", method= RequestMethod.GET)
    public String bookedGet(HttpSession session, Model model){
        User user = (User) session.getAttribute("LoggedInUser");
        List<Booking> booked = bookedService.findAllByUser(user);
        model.addAttribute("bookings", booked);
        return "booked";
    }
}
