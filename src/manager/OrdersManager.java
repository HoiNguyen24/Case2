package src.manager;

import src.IOManager.IOOrders;
import src.model.Clothes;
import src.model.Orders;
import src.model.PhotoDecal;
import src.model.Product;

import java.util.ArrayList;

import static src.manager.ClothesManager.scanner;

public class OrdersManager {
    ArrayList<Orders> orders = new ArrayList<>();

    private ProductManager productManager;

    public OrdersManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public void read() {
        this.orders = IOOrders.read(this.productManager);
    }

    public void write() {
        IOOrders.write(orders);
    }
    public void display(){
        for (Orders order:
             orders) {
            System.out.println(order);
        }
    }
    public void displayByCode(){
        System.out.println("Nhập mã của đơn hàng muốn tìm: ");
        String code = scanner.nextLine();
        for (Orders order:
             orders) {
            if(order.getCode().equals(code)){
                System.out.println(order);
                break;
            }
        }
    }
    public long profitPerOrder(ArrayList<Product> product){
        long capital = 0,revenue = 0;
        for(int j = 0 ; j < product.size();j++){
            capital += product.get(j).getPrice();
            revenue += product.get(j).getClothes().getPrice() + product.get(j).getPhotoDecal().getPrice();
        }
        return revenue - capital;
    }
    public void displayProfitEO(){
        for (int i = 0; i < orders.size(); i++) {
            ArrayList<Product> product = orders.get(i).getProducts();
            System.out.println("lợi nhuận của đơn " + orders.get(i).getCode()+":"+ profitPerOrder(product));
        }
    }
    public void displayProfitAO(){
        long profit = 0;
        for (int i = 0; i < orders.size(); i++) {
            ArrayList<Product> product = orders.get(i).getProducts();
            profit += profitPerOrder(product);
        }
        System.out.println("lợi nhuận của tất cả các đơn:"+ profit);
    }
    public void minusQuantityC(Product product,ArrayList<Clothes> cloth) {
        for (int i = 0; i < cloth.size(); i++) {
            if (product.getName().equals(cloth.get(i))) {
                cloth.get(i).setQuantity(product.getQuantity() - cloth.get(i).getQuantity());
                break;
            }
        }
    }
    public void minusQuantityD(Product product,ArrayList<PhotoDecal> decal){
        for(int i = 0 ; i < decal.size();i++){
            if(product.getName().equals(decal.get(i))){
                decal.get(i).setQuantity(product.getQuantity() - decal.get(i).getQuantity());
                break;
            }
        }
    }
    public void displayLackOrders(ClothesManager clothesManager,DecalManager decalManager){
        ArrayList<Clothes> cloth = clothesManager.clothes;
        ArrayList<PhotoDecal> photo = decalManager.photos;
        for(int i = 0 ; i < orders.size(); i++){
             ArrayList<Product> product = orders.get(i).getProducts();
             for(int  j  = 0 ; j < product.size();j++){
                 minusQuantityD(product.get(j),photo);
                 minusQuantityC(product.get(j),cloth);
             }
        }
        System.out.println("======== Áo còn thiếu ============");
        for(int i = 0 ; i < clothesManager.clothes.size();i++){
            if(clothesManager.clothes.get(i).getQuantity() < 0){
                System.out.println(clothesManager.clothes.get(i).getName()+":"+(-clothesManager.clothes.get(i).getQuantity()));
            }
        }
        System.out.println("========= Hình còn thiếu ==========");
        for(int i = 0 ; i < decalManager.photos.size();i++){
            if(decalManager.photos.get(i).getQuantity() < 0){
                System.out.println(clothesManager.clothes.get(i).getName()+":"+(-clothesManager.clothes.get(i).getQuantity()));
            }
        }
    }
}
