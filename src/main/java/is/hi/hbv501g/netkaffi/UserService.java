package is.hi.hbv501g.netkaffi;

import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    User user1 = new User(
            "Hallo",
            "Heimur",
            false
    );

    User user2 = new User(
            "hihi",
            "haha",
            false
    );

    private List<User> Users = new ArrayList<>(Arrays.asList(user1, user2));
    public List<User> getAllUsers() {

        return Users;

    }

    public User getUser(String name) {
        User user = Users.stream()
                .filter(t -> name.equals(t.getName()))
                .findFirst()
                .orElse(null);

        return user;
    }

    public void addUser(User user){
        Users.add(user);
    }
}
