package src.model;

public class PhotoDecal {
    private String name;
    private String code;
    private double width;
    private double length;
    private long price;

    public PhotoDecal(String name,String code, double width, double length, long price) {
        this.name = name;
        this.code = code;
        this.width = width;
        this.length = length;
        this.price = price;
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

    @Override
    public String toString() {
        return "PhotoDecal{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", price=" + price +
                '}';
    }
}
