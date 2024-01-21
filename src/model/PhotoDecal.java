package src.model;

import java.io.Serializable;

public class PhotoDecal implements Serializable {
    private String name;
    private String code;
    private double width;
    private double length;
    private long price;

    private long quantity;
    private Dates dates;

    public void addHistory(){
        dates.add();
    }
    public PhotoDecal(String name, String code, double width, double length, long price, long quantity,Dates dates) {
        this.name = name;
        this.code = code;
        this.width = width;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
        this.dates = dates;
    }

    public PhotoDecal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "PhotoDecal{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
