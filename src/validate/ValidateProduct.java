package src.validate;

import src.model.Product;

import java.util.ArrayList;

import static src.validate.ClothesValidate.scanner;

public class ValidateProduct {
    public static boolean checkName(ArrayList<Product> products,String name){
        for(Product product: products){
            if(name.equals(product.getName())){
                return false;
            }
        }
        return true;

    }
    public static String name(ArrayList<Product> products) {
        StringBuffer stringBuffer = new StringBuffer();
        while(!checkName(products,stringBuffer.toString())){
            System.out.println("Nhập tên mẫu áo: ");
            if(stringBuffer.length() > 0){
                stringBuffer.delete(0,stringBuffer.length() -1);
            }
            stringBuffer.append(scanner.nextLine());
        }
        return stringBuffer.toString();
    }

    public static boolean checkCode(ArrayList<Product> products,String name){
        for(Product product: products){
            if(name.equals(product.getName())){
                return false;
            }
        }
        return true;

    }

    public static String code(ArrayList<Product> products){
        StringBuffer stringBuffer = new StringBuffer();
        while(!checkCode(products,stringBuffer.toString())){
            System.out.println("Nhập tên mẫu áo: ");
            if(stringBuffer.length() > 0){
                stringBuffer.delete(0,stringBuffer.length() -1);
            }
            stringBuffer.append(scanner.nextLine());
        }
        return stringBuffer.toString();
    }
}
