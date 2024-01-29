package src.validate;

import src.model.Clothes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.manager.ClothesManager;

public class ClothesValidate {
    static Scanner scanner = new Scanner(System.in);

    public static boolean checkName(ArrayList<Clothes> clothes, String name) {
//        Pattern pattern = Pattern.compile("^[A-Z]+");
//        Matcher matcher = pattern.matcher(name.toString());
//        if (matcher.find()) return false;
        for (Clothes clothe :
                clothes) {
            if (name.equals(clothe.getName()))
                return false;
        }
        return true;
    }

    public static StringBuffer Name(ArrayList<Clothes> clothes) {
        System.out.println("Nhập tên sản phẩm: ");
        StringBuffer stringBuffer = new StringBuffer();
        do {
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(scanner.nextLine());
        } while (!checkName(clothes, stringBuffer.toString()));
        return stringBuffer;
    }

    public static boolean checkCode(ArrayList<Clothes> clothes, String code) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6}");
        Matcher matcher = pattern.matcher(code.toString());
        if (matcher.find()) return false;
        for (Clothes clothe :
                clothes) {
            if (code.toString().equals(clothe.getCode()))
                return false;
        }
        return true;
    }

    public static StringBuffer Code(ArrayList<Clothes> clothes) {
        StringBuffer stringBuffer = new StringBuffer();
        do {
            System.out.println("Nhập mã sản phẩm: ");
            stringBuffer.delete(0, stringBuffer.length());
            stringBuffer.append(scanner.nextLine());
        } while (!checkCode(clothes, stringBuffer.toString()));
        return stringBuffer;
    }
}
