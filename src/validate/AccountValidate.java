package src.validate;

import src.model.Account;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static src.validate.ClothesValidate.scanner;

public class AccountValidate {

    public static boolean checkName(ArrayList<Account> accounts,String name){
        for (Account account:
             accounts) {
             if(name.equals(account.getName()))
                 return false;
        }
        return true;
    }
    public static String name(ArrayList<Account> accounts){
        StringBuffer stringBuffer = new StringBuffer();
        do{
            System.out.println("Nhập tên: ");
            stringBuffer.delete(0,stringBuffer.length()-1);
            stringBuffer.append(scanner.nextLine());
        }while(!checkName(accounts,stringBuffer.toString()));
        return stringBuffer.toString();
    }

    public static boolean checkPassword(ArrayList<Account> accounts,String password){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(password);
        if(!matcher.find()) return false;
        for(Account account: accounts){
            if(password.equals(account.getPassword())) return false;
        }
        return true;
    }
    public static String password(ArrayList<Account> accounts){
        StringBuffer stringBuffer = new StringBuffer();
        do{
            System.out.println("Nhập mật khẩu: ");
            stringBuffer.delete(0,stringBuffer.length()-1);
            stringBuffer.append(scanner.nextLine());
        }while(!checkPassword(accounts,stringBuffer.toString()));
        return stringBuffer.toString();
    }
}
