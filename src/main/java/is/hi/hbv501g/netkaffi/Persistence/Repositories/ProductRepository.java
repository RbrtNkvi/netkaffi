package is.hi.hbv501g.netkaffi.Persistence.Repositories;

import is.hi.hbv501g.netkaffi.Persistence.Entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.function.Function;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAll();
    Product findByName(String name);
    List<Product> findByType(String type);
    Product save(Product product);
}
