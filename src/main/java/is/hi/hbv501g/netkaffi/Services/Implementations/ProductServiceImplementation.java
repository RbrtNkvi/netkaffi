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

    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    @Override
    public Product findByName(String name){
        return productRepository.findByName(name);
    }
    @Override
    public List<Product> findByType(String type){
        return productRepository.findByType(type);
    }
    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }
    @Override
    public Product edit(Product product){
        Product exists = productRepository.findByName(product.getName());
        if(exists != null){
            exists.setDeleted(true);
            productRepository.save(exists);
        }
        return exists;
    }
}
