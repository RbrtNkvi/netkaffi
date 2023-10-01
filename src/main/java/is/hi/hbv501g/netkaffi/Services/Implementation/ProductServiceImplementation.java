package is.hi.hbv501g.netkaffi.Services.Implementation;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    private List<Product> productRepository = new ArrayList<>();

    @Autowired
    public ProductServiceImplementation() {
        // Create 5 random products for the dummy repository which will be removed when JPA is added.
        productRepository.add(new Product("Computer1","Computer",2500,false));
        productRepository.add(new Product("Computer2","Computer",5000,true));
        productRepository.add(new Product("Computer3","Computer",5000,false));
        productRepository.add(new Product("Room1","Room",15000,false));
        productRepository.add(new Product("Room2","Room",10000,false));
    }

    @Override
    public List<Product> findAll() {
        return productRepository;
    }

    @Override
    public List<Product> findAllActive(){
        List<Product> ps = new ArrayList<>();
        for (Product p:productRepository)
            if (p.isDELETED() == false)
                ps.add(p);
        if (ps.isEmpty()==false)
            return ps;
        return null;
    }

    @Override
    public List<Product> findByType(String type) {
        List<Product> ps = new ArrayList<>();
        for (Product p:productRepository)
            if (p.getType().equals(type)){
                ps.add(p);
            }
        if (ps.isEmpty()==false){
            return ps;
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        for (Product p:productRepository)
            if (p.getName().equals(name)){
                return p;
            }
        return null;
    }

    @Override
    public Product save(Product product) {
        product.setDELETED(false);
        productRepository.add(product);
        return product;
    }

    @Override
    public Product edit(Product product) {
        product.setDELETED(true);
        return product;
    }
}
