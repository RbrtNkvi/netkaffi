package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGet(User user) {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "redirect:/signup";
        }
        User exists = userService.findByUsername((user.getUsername()));
        if (exists == null) {
            userService.save(user);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
    public String getUser(@PathVariable String name, Model model) {
        User user = userService.findByUsername(name);
        model.addAttribute("users",user);
        return "user";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginPost(User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "redirect:/";
        }
        User exists = userService.login(user);
        if(exists != null){
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser", exists);
            if (exists.getIsAdmin() == true) {
                return "redirect:/products";
            }
            return "redirect:/main";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginGet(User user){
        return "login";
    }

    @RequestMapping(value = "/loggedinuser", method = RequestMethod.GET)
    public String loggedinGet(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser != null) {
            model.addAttribute("LoggedInUser", sessionUser);
            return "loggedInUser";
        }
        return "redirect:/";
    }
}
