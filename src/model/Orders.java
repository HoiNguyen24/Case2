package src.model;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Date;

public class Orders {
    private String code;
    private String phonenumber;
    private String address;

    ArrayList<Product> products;

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

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Product product :
                products) {
            stringBuffer.append(product.getCode() + "," + product.getQuantity());
        }
        return "|" + code + "," + phonenumber + "," + address + "|" + stringBuffer;
    }
}
