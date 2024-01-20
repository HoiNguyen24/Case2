package src.manager;

import src.IOManager.IOOrders;
import src.model.Orders;

import java.util.ArrayList;

public class OrdersManager {
    ArrayList<Orders> orders = new ArrayList<>();

    private ProductManager productManager ;

    public OrdersManager(ProductManager productManager){
        this.productManager = productManager;
    }
    public void read(){
        IOOrders.read(productManager);
    }
    public void write(){
        IOOrders.write(orders);
    }
}
