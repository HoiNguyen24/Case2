package src.model;

public class Product {
    private String name;
    private String code;
    private Clothes clothes;
    private PhotoDecal photoDecal;
    private String tempName;
    private long price;
    private long quantity;

    public Product(String name,String code,Clothes clothes, PhotoDecal photoDecal,long price) {
        this.name = name;
        this.code = code;
        this.clothes = clothes;
        this.photoDecal = photoDecal;
        this.price = price;
    }

    public Product() {
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public PhotoDecal getPhotoDecal() {
        return photoDecal;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setPhotoDecal(PhotoDecal photoDecal) {
        this.photoDecal = photoDecal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + price +
                ", clothes=" + clothes +
                ", photoDecal=" + photoDecal +
                ", price=" + price +
                '}';
    }
}
