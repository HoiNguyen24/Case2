package src.model;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Date;

public class Orders {
    private String code;
    private String phonenumber;
    private String address;

    ArrayList<Product> products = new ArrayList<>();

    public Orders(String code, String phonenumber, String address, ArrayList<Product> products) {
        this.code = code;
        this.phonenumber = phonenumber;
        this.address = address;
        this.products = products;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public int getProduct(String name){
            for(int  i = 0 ; i < products.size();i++){
                if(name.equals(products.get(i).getName()))
                    return i;
            }
            return -1;
    }
    public void setQuantity(int i,long quantity){
        products.get(i).setQuantity(products.get(i).getQuantity() + quantity);
    }

    public boolean checkProduct(String name){
        for (Product product:
             products) {
            if(product.getName().equals(name))
                return false;
        }
        return true;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public void add(Product product){
        products.add(product);
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Product product :
                products) {
            stringBuffer.append(product.getName() + "," + product.getQuantity());
        }
        return code + "," + phonenumber + "," + address + "LLL" + stringBuffer;
    }
}
