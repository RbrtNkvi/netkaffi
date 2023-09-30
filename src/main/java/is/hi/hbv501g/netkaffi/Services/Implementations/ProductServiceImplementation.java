package is.hi.hbv501g.netkaffi.Services.Implementations;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import is.hi.hbv501g.netkaffi.Persistence.Repositories.ProductRepository;
import is.hi.hbv501g.netkaffi.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findByName(String name){
        return productRepository.findByName(name);
    }
    public List<Product> findByType(String type){
        return productRepository.findByType(type);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public Product edit(Product product){
        Product exists = productRepository.findByName(product.getName());
        if(exists != null){
            exists.setDeleted(true);
            productRepository.save(exists);
        }
        return exists;
    }
}
