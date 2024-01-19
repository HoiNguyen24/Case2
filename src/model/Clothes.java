package src.model;

public class Clothes {
    private String code;
    private String name;

    private String type;

    private String color;

    private long price;

    private long quantity;

    public Clothes(String name, String type, String color, long price,long quantity, String code) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.code = code;
    }
    public Clothes(){

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
