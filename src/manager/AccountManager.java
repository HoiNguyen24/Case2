package src.manager;

import src.model.Account;
import src.validate.AccountValidate;

import java.io.BufferedWriter;
import java.util.ArrayList;

import static src.manager.ClothesManager.scanner;

public class AccountManager {
    ArrayList<Account> accounts = new ArrayList<>();

    public AccountManager(){
        accounts.add(new Account("admin","admin","admin"));
    }
    public void add(Account account){
        accounts.add(account);
    }
    public Account create(){
        String name = AccountValidate.name(accounts);
        String password = AccountValidate.password(accounts);
        return new Account(name,password,"Staff");
    }
    public void ChangePassword(Account account){
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("Nhập mật khẩu cũ");
        stringBuffer.append(scanner.nextLine());
        if(!stringBuffer.toString().equals(account.getPassword())) return;
    }
}
