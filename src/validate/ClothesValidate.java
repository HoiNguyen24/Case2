package src.validate;

import src.model.Clothes;

import java.util.ArrayList;
import java.util.Scanner;

import src.manager.ClothesManager;

public class ClothesValidate {
    static Scanner scanner = new Scanner(System.in);

    public static boolean checkName(ArrayList<Clothes> clothes,StringBuffer name){
        for (Clothes clothe:
                clothes) {
            if(name.equals(clothe.getName()))
                return false;
        }
        return true;
    }

    public static StringBuffer Name(ArrayList<Clothes> clothes){
        System.out.println("Nhập tên sản phẩm: ");
        StringBuffer stringBuffer = new StringBuffer();
        while(!checkName(clothes,stringBuffer)){
            stringBuffer.delete(0,stringBuffer.length()-1);
            stringBuffer.append(scanner.nextLine());
        }
        return stringBuffer;
    }

    public static boolean checkCode(ArrayList<Clothes> clothes,StringBuffer code){
        for (Clothes clothe:
                clothes) {
            if(code.equals(clothe.getCode()))
                return false;
        }
        return true;
    }

    public static StringBuffer Code(ArrayList<Clothes> clothes){
        System.out.println("Nhập mã sản phẩm: ");
        StringBuffer stringBuffer = new StringBuffer();
        while(!checkCode(clothes,stringBuffer)){
            stringBuffer.delete(0,stringBuffer.length()-1);
            stringBuffer.append(scanner.nextLine());
        }
        return stringBuffer;
    }
}
