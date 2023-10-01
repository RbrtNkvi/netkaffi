package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class HomeController {
    private ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/home")
    public String productGet(Model model) {
        //Call a method in a Service Class
        List<Product> allActiveProducts = productService.findAllActive();
        //Add some data to the Model
        model.addAttribute("products", allActiveProducts);
        return "home";
    }

}
