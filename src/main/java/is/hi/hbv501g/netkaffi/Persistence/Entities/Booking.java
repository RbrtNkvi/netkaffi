package is.hi.hbv501g.netkaffi.Persistence.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="bookings")
@IdClass(BookingId.class)
public class Booking {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Id
    private int starttime;

    public Booking(){

    }

    public Booking(User user, Product product, int starttime){
        this.user = user;
        this.product = product;
        this.starttime = starttime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public int getEndtime(){
        return this.starttime+1;
    }
}
