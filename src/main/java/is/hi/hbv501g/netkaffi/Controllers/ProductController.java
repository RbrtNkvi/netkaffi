package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/productPage")
    public String productsGet(Model model) {
        //Call a method in a Service Class
        List<Product> allProducts = productService.findAll();
        //Add some data to the Model
        model.addAttribute("products", allProducts);
        return "productPage";
    }

    @RequestMapping(value="/addproduct", method = RequestMethod.GET)
    public String productAddForm(Product product) {
        return "addProduct";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String productAdd(Product product, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "addproduct";
        }
        productService.save(product);
        return "redirect:/productPage";
    }
    @RequestMapping(value="/remove/{name}",method = RequestMethod.GET)
    public String productDelete(@PathVariable("name") String name, Model model) {
        Product productToRemove = productService.findByName(name);
        productService.edit(productToRemove);
        return "redirect:/productPage";
    }
}
