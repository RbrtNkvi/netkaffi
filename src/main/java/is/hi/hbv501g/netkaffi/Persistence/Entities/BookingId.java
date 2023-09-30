package is.hi.hbv501g.netkaffi.Persistence.Entities;

import java.io.Serializable;
import java.util.Objects;

public class BookingId implements Serializable {
    private User user;

    private Product product;

    private int starttime;

    public BookingId(){

    }
    public BookingId(User user, Product product, int starttime) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingId bookingId = (BookingId) o;
        return starttime == bookingId.starttime && Objects.equals(user, bookingId.user) && Objects.equals(product, bookingId.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, product, starttime);
    }
}