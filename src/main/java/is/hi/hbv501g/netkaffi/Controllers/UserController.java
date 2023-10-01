package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.User;
import is.hi.hbv501g.netkaffi.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private is.hi.hbv501g.netkaffi.UserService UserService;
    @RequestMapping(value="/Users")
    public List<User> getAllUsers() {

        return UserService.getAllUsers();
    }

    @RequestMapping(value = "/Users/{name}")
    public User getUser(@PathVariable String name) {
        return UserService.getUser(name);
    }

    @RequestMapping(value = "/Users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        UserService.addUser(user);
    }
}
