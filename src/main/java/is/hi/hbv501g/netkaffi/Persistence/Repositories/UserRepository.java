package is.hi.hbv501g.netkaffi.Persistence.Repositories;
import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByUsername(String username);
}