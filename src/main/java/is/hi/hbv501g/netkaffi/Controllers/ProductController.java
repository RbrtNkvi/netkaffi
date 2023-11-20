package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    /**
     * Fetching the products for use in products.html
     *
     * @param product
     * @param model
     * @return direction to products.html with products information
     */
    @RequestMapping(value="/products", method = RequestMethod.GET)
    public String productsGet(Product product, Model model){
        List<Product> allProducts = productService.findAll();
        model.addAttribute("products", allProducts);
        return "products";
    }

    //Directs to addProduct.html
    @RequestMapping(value="/addproduct", method = RequestMethod.GET)
    public String addProductGet(Product product){
        return "addProduct";
    }

    /**
     * Adds a new product to PSQL database
     *
     * @param product new product information
     * @param result
     * @param model
     * @return redirect to products.html
     */
    @RequestMapping(value="/addproduct", method = RequestMethod.POST)
    public String addProductPost(Product product, BindingResult result, Model model){
        if(result.hasErrors()){
            return "newBook";
        }
        productService.save(product);
        return "redirect:/products";
    }

    /**
     * Product gets set to deleted, so it can no longer be booked
     *
     * @param name product name
     * @param model
     * @return redirect to products.html
     */
    @RequestMapping(value="/delete/{name}", method = RequestMethod.POST)
    public String productDelete(@PathVariable("name") String name, Model model){
        Product productToDelete = productService.findByName(name);
        productService.edit(productToDelete);
        return "redirect:/products";
    }
}
