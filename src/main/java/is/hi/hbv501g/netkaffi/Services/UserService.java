package is.hi.hbv501g.netkaffi.Services;

import is.hi.hbv501g.netkaffi.Persistence.Entities.User;

public interface UserService {
    User save(User user);
    User findByUsername(String username);
    User login(User user);
}
