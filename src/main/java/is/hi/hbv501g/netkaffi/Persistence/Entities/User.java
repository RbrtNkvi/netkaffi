package is.hi.hbv501g.netkaffi.Persistence.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    private String username;

    private String password;
    private Boolean isadmin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings = new ArrayList<>();


    public User(String name, String password, Boolean isAdmin){
        this.username = name;
        this.password = password;
        this.isadmin = isAdmin;
    }

    public User(String name, String password){
        this.username = name;
        this.password = password;
        this.isadmin = false;
    }

    public User() {

    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Boolean getIsAdmin(){
        return isadmin;
    }

    public void setIsAdmin(boolean isAdmin){
        this.isadmin = isAdmin;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
