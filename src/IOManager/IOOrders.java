package src.IOManager;

import src.manager.ProductManager;
import src.model.Orders;
import src.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static ArrayList<Orders> read(ProductManager productManager) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = "";
            ArrayList<Orders> orders = new ArrayList<>();

            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
                String[] arr = str.split("LLL");
                System.out.println(Arrays.toString(arr));
                String[] info = arr[0].split(",");
                System.out.println(Arrays.toString(info));
                String[] product = arr[1].split(",");
                System.out.println(Arrays.toString(product));
                ArrayList<Product> productArr = new ArrayList<>();
                for (int i = 0; i < product.length-1; i += 2) {
                    System.out.println(product[i]);
                    System.out.println(product[i+1]);
                    Product temp = productManager.getProducts().get(productManager.findByCode());
                    temp.setQuantity(Long.parseLong(product[i + 1]));
                    productArr.add(temp);
                }
                orders.add(new Orders(info[0], info[1], info[2], productArr));
            }
            bufferedReader.close();
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
