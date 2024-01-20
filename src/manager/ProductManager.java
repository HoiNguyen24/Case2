package src.manager;

import src.model.Clothes;
import src.model.PhotoDecal;
import src.model.Product;

import java.util.ArrayList;

public class ProductManager {

    ArrayList<PhotoDecal> photoDecals = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Clothes> clothes = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public void delete(int index) {
        products.remove(index);
    }

    public void edit(int index,Product product){
        products.set(index,product);
    }
    public void display(){
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product create(){
        String name =
    }
}
