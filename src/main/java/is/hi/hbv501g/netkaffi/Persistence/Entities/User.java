package is.hi.hbv501g.netkaffi.Persistence.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="\"User\"")
public class User {

    @Id
    private String name;

    private String password;
    private Boolean isAdmin;


    public User(String name, String password, Boolean isAdmin){
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User() {

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
