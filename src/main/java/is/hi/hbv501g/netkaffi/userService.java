package is.hi.hbv501g.netkaffi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class userService {

    user user1 = new user(
            "Hallo",
            "Heimur",
            false
    );

    user user2 = new user(
            "hihi",
            "haha",
            false
    );

    private List<user> users = new ArrayList<>(Arrays.asList(user1, user2));
    public List<user> getAllUsers() {

        return users;

    }

    public user getUser(String name) {
        user user = users.stream()
                .filter(t -> name.equals(t.getName()))
                .findFirst()
                .orElse(null);

        return user;
    }

    public void addUser(user user){
        users.add(user);
    }
}
