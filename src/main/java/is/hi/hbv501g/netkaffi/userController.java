package is.hi.hbv501g.netkaffi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class userController {
    @Autowired
    private userService userService;
    @RequestMapping(value="/users")
    public List<user> getAllUsers() {

        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{name}")
    public user getUser(@PathVariable String name) {
        return userService.getUser(name);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody user user){
        userService.addUser(user);
    }
}
