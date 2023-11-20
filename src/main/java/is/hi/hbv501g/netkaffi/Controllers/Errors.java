package is.hi.hbv501g.netkaffi.Controllers;

import is.hi.hbv501g.netkaffi.Persistence.Entities.User;

public class Errors {

    public static int checkUser(User user){
        if( user == null ){
            return 0;
        }
        return 1;
    }
}
