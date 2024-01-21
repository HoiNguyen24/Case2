package src.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Clothes implements Serializable {
    private String code;
    private String name;

    private String type;

    private String color;

    private long price;

    private long quantity;

    private Dates dates;

    public void addHistory(){
       dates.add();
    }
    public Clothes(String name, String type, String color, long price, long quantity, String code,Dates dates) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.code = code;
        this.dates = dates;
    }

    public Clothes() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return "Clothes{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", code='" + code + '\'' +
                '}';
    }
}
