package src.manager;

import src.IOManager.IOAccount;
import src.model.Account;
import src.validate.AccountValidate;

import java.io.BufferedWriter;
import java.util.ArrayList;

import static src.manager.ClothesManager.scanner;

public class AccountManager {
    ArrayList<Account> accounts = new ArrayList<>();

    public AccountManager() {
        accounts.add(new Account("admin", "admin", "admin"));
    }
    public void write(){
        IOAccount.write(accounts);
    }
    public void read(){
        accounts = IOAccount.read();
    }
    public void display(){
        for (Account account:
             accounts) {
            System.out.println(account);
        }
    }
    public void add(Account account) {
        accounts.add(account);
    }

    public Account create() {
        String name = AccountValidate.name(accounts);
        String password = AccountValidate.password(accounts);
        return new Account(name, password, "Staff");
    }

    public void ChangePassword(Account account) {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("Nhập mật khẩu cũ");
        stringBuffer.append(scanner.nextLine());
        if (!stringBuffer.toString().equals(account.getPassword())) return;
        else {
            stringBuffer.delete(0, stringBuffer.length());
            System.out.println("Nhập mật khẩu mới");
            stringBuffer.append(AccountValidate.password(accounts));
            System.out.println("Nhập lại mật khẩu");
            String repassword = scanner.nextLine();
            if (!repassword.equals(stringBuffer.toString())) return;
            else account.setPassword(repassword);
        }
    }
    public void delete(){
        System.out.println("nhập tên tài khoản muốn xóa");
        String name = scanner.nextLine();
        for(int i = 0 ; i < accounts.size();i++){
            if(accounts.get(i).getName().equals(name)){
                accounts.remove(i);
                break;
            }
        }
    }
    public Account checkLogin(String name, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (name.equals(accounts.get(i).getName()) && password.equals(accounts.get(i).getPassword()))
                return accounts.get(i);
        }
        return null;
    }
}
