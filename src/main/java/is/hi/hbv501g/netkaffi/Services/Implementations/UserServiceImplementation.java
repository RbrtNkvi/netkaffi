package is.hi.hbv501g.netkaffi.Services.Implementations;

import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.Persistence.Repositories.UserRepository;
import is.hi.hbv501g.netkaffi.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        userRepository.save(user);
        return user;
    }

    public User findByUsername(String username){
       return userRepository.findByUsername(username);
    }

    @Override
    public User login(User user) {
        User doesExist = userRepository.findByUsername(user.getUsername());
        if(doesExist != null){
            if(doesExist.getPassword().equals(user.getPassword())){
                return doesExist;
            }
        }
        return null;
    }
}
