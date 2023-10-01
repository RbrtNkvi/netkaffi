package is.hi.hbv501g.netkaffi.Persistence.Entities;


public class Product {
    private String name;
    private String type;
    private int price;
    private boolean DELETED;

    public Product() {
    }

    public Product(String name, String type, int price, boolean DELETED) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.DELETED = DELETED;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDELETED() {
        return DELETED;
    }

    public void setDELETED(boolean DELETED) {
        this.DELETED = DELETED;
    }
}
