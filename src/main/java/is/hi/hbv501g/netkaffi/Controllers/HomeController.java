package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

    ProductService productService;

    @Autowired
    public HomeController(ProductService productService){
        this.productService = productService;
    }
    @RequestMapping(value="/main", method = RequestMethod.GET)
    public String productsGet(Product product, Model model, HttpSession session) {
        User user = (User) session.getAttribute("LoggedInUser");
        if( Errors.checkUser(user) == 0 ){
            return "redirect:/login";
        }
        List<Product> allProducts = productService.findAll();
        model.addAttribute("products", allProducts);
        return "main";
    }

}
