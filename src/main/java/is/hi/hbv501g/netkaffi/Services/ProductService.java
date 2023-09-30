package is.hi.hbv501g.netkaffi.Services;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findByName(String name);
    List<Product> findByType(String type);
    Product save(Product product);
    Product edit(Product product);
}
