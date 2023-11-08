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
    private long starttime;

    public Booking(){

    }

    public Booking(User user, Product product, long starttime){
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

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getEndtime(){
        return this.starttime+1;
    }
}
