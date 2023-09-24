package is.hi.hbv501g.netkaffi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="\"user\"")
public class user {

    @Id
    private String name;

    private String password;
    private Boolean isAdmin;


    public user(String name, String password, Boolean isAdmin){
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public user() {

    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public Boolean getIsAdmin(){
        return isAdmin;
    }
}
