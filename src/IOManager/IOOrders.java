package src.IOManager;

import src.manager.ProductManager;
import src.model.Orders;
import src.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOOrders {
    static File file = new File("orders.txt");

    public static void write(List<Orders> orders) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Orders order :
                    orders) {
                bufferedWriter.write(order.toString());
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Orders> read(ProductManager productManager) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuffer stringBuffer = new StringBuffer();
            List<Orders> orders = new ArrayList<>();
            while (bufferedReader.readLine() != null) {
                stringBuffer.append(bufferedReader.readLine());
                String[] arr = (stringBuffer.toString()).split("|");
                String[] info = arr[0].split(",");
                String[] product = arr[1].split(",");
                ArrayList<Product> productArr = new ArrayList<>();
                for (int i = 0; i < product.length; i += 2) {
                    Product temp = productManager.getProducts().get(productManager.findByCode(product[i]));
                    temp.setQuantity(Long.parseLong(product[i + 1]));
                    productArr.add(temp);
                }
                orders.add(new Orders(info[0], info[1], info[2], productArr));
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
