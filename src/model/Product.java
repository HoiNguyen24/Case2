package src.model;

public class Product {

    private String code;
    private Clothes clothes;
    private PhotoDecal photoDecal;

    private long price;

    public Product(String code,Clothes clothes, PhotoDecal photoDecal,long price) {
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
