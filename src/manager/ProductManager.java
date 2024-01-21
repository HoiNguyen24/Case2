package src.manager;

import src.IOManager.IOProduct;
import src.model.Clothes;
import src.model.PhotoDecal;
import src.model.Product;
import src.validate.ProductValidate;

import java.util.ArrayList;

import static src.manager.ClothesManager.scanner;

public class ProductManager {

    ClothesManager clothesManager = new ClothesManager();

    DecalManager decalManager = new DecalManager();
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product>

    getProducts() {
        return this.products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public void delete(int index) {
        products.remove(index);
    }

    public void edit(int index, Product product) {
        products.set(index, product);
    }

    public void write(){
        IOProduct.write(products);
    }
    public void read(){
        products = IOProduct.read();
    }
    public void display() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void displayType() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(scanner.nextLine());
        for (Product product :
                products) {
            if (stringBuffer.toString().equals(product.getClothes().getType()))
                System.out.println(product);
        }
    }

    public void displayPrice() {
        long l, r;
        System.out.println("Nhập giá thâp nhất: ");
        while (true) {
            try {
                l = Long.parseLong(scanner.nextLine());
                break;
            } catch (Exception e) {

            }
        }
        System.out.println("Nhập giá cao nhất: ");
        while (true) {
            try {
                r = Long.parseLong(scanner.nextLine());
                break;
            } catch (Exception e) {

            }
        }
        for (Product product :
                products) {
            if (product.getPrice() > l && product.getPrice() < r)
                System.out.println(product);
        }
    }

    public void displayColor() {
        String color = scanner.nextLine();
        for (Product product : products) {
            if (color.equals(product.getClothes().getColor()))
                System.out.println(product);
        }
    }

    public Product create() {
        String name = ProductValidate.name(products);
        String code = ProductValidate.code(products);
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("Nhập mã áo: ");
        stringBuffer.append(scanner.nextLine());
        Clothes cloth = clothesManager.clothes.get(clothesManager.FindbyCode(stringBuffer.toString()));
        stringBuffer.delete(0, stringBuffer.length());
        System.out.println("Nhập mã hình: ");
        stringBuffer.append(scanner.nextLine());
        PhotoDecal decal = decalManager.photos.get(decalManager.FindByCode(stringBuffer.toString()));
        stringBuffer.delete(0, stringBuffer.length());
        long price;
        while (true) {
            stringBuffer.delete(0, stringBuffer.length());
            System.out.println("Nhập giá mẫu áo: ");
            try {
                price = Long.parseLong(stringBuffer.append(scanner.nextLine()).toString());
                break;
            } catch (Exception e) {
                System.out.println("Nhập lại");
            }
        }
        return new Product(name, code, cloth, decal, price);
    }

    public int findByCode(String code) {
        for (int i = 0; i < products.size(); i++) {
            if (code.equals(products.get(i))) return i;
        }
        return -1;
    }

    public void delete() {
        display();
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("Nhập mã mẫu áo muốn xóa: ");
        if (findByCode(stringBuffer.toString()) == -1) System.out.println("Không tìm thấy mẫu áo muốn xóa");
        else delete(findByCode(stringBuffer.toString()));
    }

    public void edit() {
        display();
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("Nhập mã mẫu áo muốn sửa: ");
        if (findByCode(stringBuffer.toString()) == -1) System.out.println("Không tìm thấy mẫu áo muốn sửa");
        else edit(findByCode(stringBuffer.toString()), create());
    }


}
