package src;

import src.manager.*;
import src.model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static src.manager.ClothesManager.scanner;

public class Menu {
    static AccountManager accountManager = new AccountManager();

    static ClothesManager clothesManager = new ClothesManager();

    static DecalManager decalManager = new DecalManager();

    static ProductManager productManager = new ProductManager();

    static OrdersManager ordersManager = new OrdersManager(productManager);

    static Scanner scanner = new Scanner(System.in);

    public static void AccountMenu(Account account) {
        while(true){
            System.out.println("1. đổi mật khẩu");
            if (account.getRole().equals("admin")) {
                System.out.println("2. thêm tài khoản mới");
                System.out.println("3. xóa tài khoản");
                System.out.println("4. in ra danh sách tài khoản");
            }
            System.out.println("10. thoát");
            StringBuffer stringBuffer = new StringBuffer();
            Pattern pattern;
            if (account.getRole().equals("admin")) {
                pattern = Pattern.compile("^[0-4]{1,2}$");
            } else {
                pattern = Pattern.compile("^[0-1]{1,2}$");
            }
                stringBuffer.delete(0, stringBuffer.length());
                System.out.println("Nhập lựa chọn: ");
                stringBuffer.append(scanner.nextLine());
                Matcher matcher = pattern.matcher(stringBuffer.toString());
                if (matcher.find()) {
                    switch (Integer.parseInt(stringBuffer.toString())) {
                        case 1:
                            accountManager.add(accountManager.create());
                            break;
                        case 2:
                            accountManager.display();
                            break;
                        case 3:
                            accountManager.delete();
                            break;
                        case 4:
                            accountManager.ChangePassword(account);
                            break;
                        case 10:
                            return;
                    }
            }
        }
    }


    public static void OrdersManagerMenu(Account account){
        while(true){
            System.out.println("1. in ra danh sách đơn");
            System.out.println("2. in ra đơn theo code");
            System.out.println("3. in ra màn hình lợi nhuận theo đơn");
            System.out.println("4. in ra màn hình lời nhuận cả danh sách đơn");
            System.out.println("5. in ra màn hình những vật phẩm còn thiếu");
            System.out.println("10. thoát");
            StringBuffer stringBuffer = new StringBuffer();
            Pattern pattern;
            if(account.getRole().equals("admin")) {
                pattern = Pattern.compile("^[0-9]{1,2}$");
            }else{
                pattern = Pattern.compile("^[0-4]{1,2}$");
            }
                stringBuffer.delete(0,stringBuffer.length());
                System.out.println("Nhập lựa chọn: ");
                stringBuffer.append(scanner.nextLine());
                Matcher matcher = pattern.matcher(stringBuffer.toString());
                if(matcher.find()){
                    switch (Integer.parseInt(stringBuffer.toString())){
                        case 1:
                            ordersManager.display();
                            break;
                        case 2:
                            ordersManager.displayByCode();
                            break;
                        case 3:
                            ordersManager.displayProfitEO();
                            break;
                        case 4:
                            ordersManager.displayProfitAO();
                            break;
                        case 5:
                            ordersManager.displayLackOrders(clothesManager,decalManager);
                            break;
                        case 10:
                            return;
                    }
            }
        }
    }
    public static void ProductManagerMenu(Account account){
        while(true){
            System.out.println("1. in ra màn hình danh sách sản phẩm");
            System.out.println("2. in ra màn hình danh sách theo loại");
            System.out.println("3. in ra màn hình danh sách theo giá");
            System.out.println("4. in ra màn hình danh sách theo màu");
            if(account.getRole().equals("admin")){
                System.out.println("5.thêm áo mới");
                System.out.println("6. xóa áo");
                System.out.println("7. sửa áo");
            }
            System.out.println("10. thoát");
            Pattern pattern;
            if(account.getRole().equals("admin")) {
                pattern = Pattern.compile("^[0-8]{1,2}$");
            }else{
                pattern = Pattern.compile("^[0-4]{1,2}$");
            }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.delete(0,stringBuffer.length());
                System.out.println("Nhập lựa chọn: ");
                stringBuffer.append(scanner.nextLine());
                Matcher matcher = pattern.matcher(stringBuffer.toString());
                if(matcher.find()){
                    switch (Integer.parseInt(stringBuffer.toString())){
                        case 1:
                            productManager.display();
                            break;
                        case 2:
                            productManager.displayType();
                            break;
                        case 3:
                            productManager.displayPrice();
                            break;
                        case 4:
                            productManager.displayColor();
                            break;
                        case 5:
                            productManager.add(productManager.create());
                            break;
                        case 6:
                            productManager.delete();
                            break;
                        case 7:
                            productManager.edit();
                        case 8:
                            return;
                    }
            }
        }
    }
    public static void DecalManagerMenu(Account account) {
        while (true) {
            System.out.println("1. in ra hình trong kho");
            System.out.println("2. in ra hình theo ngày nhập");
            System.out.println("3. in ra hình theo tên");
            System.out.println("4. in ra lịch sử thêm tất cả các hình");
            System.out.println("5. in ra lịch sử thêm theo mã");
            if (account.getRole().equals("admin")) {
                System.out.println("6. thêm hình mới");
                System.out.println("7. thêm đơn vị hình");
                System.out.println("8. sửa hình");
                System.out.println("9. xóa hình");
            }
            System.out.println("10. thoát");
            Pattern pattern;
            if (account.getRole().equals("admin")) {
                pattern = Pattern.compile("^[0-9]{1,2}$");
            } else {
                pattern = Pattern.compile("^[0-4]{1,2}]$");
            }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.delete(0, stringBuffer.length());
                System.out.println("Nhập lựa chọn: ");
                stringBuffer.append(scanner.nextLine());
                Matcher matcher = pattern.matcher(stringBuffer.toString());
                if (matcher.find()) {
                    switch (Integer.parseInt(stringBuffer.toString())) {
                        case 1:
                            decalManager.display();
                            break;
                        case 2:
                            decalManager.displayByDay();
                            break;
                        case 3:
                            String target = scanner.nextLine();
                            System.out.println(decalManager.getPhotos().get(decalManager.FindByCode(target)));
                            break;
                        case 4:
                            decalManager.displayAllHistory();
                            break;
                        case 5:
                            decalManager.displayHistory();
                            break;
                        case 6:
                            System.out.println("====== thêm mã áo mới ======");
                            decalManager.add(decalManager.create());
                            break;
                        case 7:
                            decalManager.addQuantity();
                            break;
                        case 8:
                            decalManager.ChooseDelete();
                            break;
                        case 9:
                            decalManager.ChooseDelete();
                            break;
                        case 10:
                            return;
                        default:
                            System.out.println("nhập lại");
                            break;
                    }
            }
        }
    }
    public static void ClothesManagerMenu(Account account){
        while (true){
            System.out.println("1. in ra danh sách áo trong kho");
            System.out.println("2. in ra danh sách áo theo ngày nhập");
            System.out.println("3. in ra danh sách áo theo mã");
            System.out.println("4. in ra lịch sử thêm tất cả các áo");
            System.out.println("5. in ra lịch sử thêm áo theo mã ");
            if(account.getRole().equals("admin")){
                System.out.println("6. thêm áo mới");
                System.out.println("7. thêm đơn vị áo");
                System.out.println("8. sửa áo");
                System.out.println("9. xóa áo");
            }
            System.out.println("10. thoát");
            Pattern pattern;
            if(account.getRole().equals("admin")) {
                pattern = Pattern.compile("^[0-9]{1,2}$");
            }else{
                pattern = Pattern.compile("^[0-4]{1,2}$");
            }
            StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.delete(0,stringBuffer.length());
                System.out.println("Nhập lựa chọn: ");
                stringBuffer.append(scanner.nextLine());
                Matcher matcher = pattern.matcher(stringBuffer.toString());
                if(matcher.find()){
                    switch (Integer.parseInt(stringBuffer.toString())){
                        case 1:
                            clothesManager.display();
                            break;
                        case 2:
                            clothesManager.displayByDay();
                            break;
                        case 3:
                            clothesManager.findByCode();
                            break;
                        case 4:
                            clothesManager.displayAllHistory();
                            break;
                        case 5:
                            clothesManager.displayHistory();
                            break;
                        case  6:
                            System.out.println("====== thêm mã áo mới ======");
                            clothesManager.add(clothesManager.create());
                            break;
                        case 7:
                            clothesManager.addQuantity();
                            break;
                        case 8:
                            clothesManager.chooseEdit();
                            break;
                        case 9:
                            clothesManager.ChooseDelete();
                            break;
                        case 10:
                            return;
                        default:
                            System.out.println("nhập lại");
                            break;
                    }
            }
        }
    }
    public static void Menu(Account account){
        while(true) {
            System.out.println("1. Quản lí áo \n" +
                    "2. Quản lí hình \n" +
                    "3. Quản lí sản phẩm \n" +
                    "4. Quản lí đơn hàng \n");
            if (account.getRole().equals("admin")) {
                System.out.println("5. Quản lí tài khoản");
            }
            System.out.println("10. thoát");
            Pattern pattern;
            if (account.getRole().equals("admin")) {
                pattern = Pattern.compile("^[0-5]{1,2}$");
            } else {
                pattern = Pattern.compile("^[0-4]{1,2}$");
            }
            StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.delete(0, stringBuffer.length());
                System.out.println("Nhập lựa chọn: ");
                stringBuffer.append(scanner.nextLine());
                Matcher matcher = pattern.matcher(stringBuffer.toString());
                if(matcher.find()){
                    switch (Integer.parseInt(stringBuffer.toString())){
                        case 1:
                            ClothesManagerMenu(account);
                            break;
                        case 2:
                            DecalManagerMenu(account);
                            break;
                        case 3:
                            ProductManagerMenu(account);
                            break;
                        case 4:
                            OrdersManagerMenu(account);
                            break;
                        case 10:
                            accountManager.write();
                            clothesManager.write();
                            decalManager.write();
                            productManager.write();
                            ordersManager.write();
                            return;
                    }
            }
        }
    }

    public static void BaseMenu() {
        accountManager.read();
        clothesManager.read();
        decalManager.read();
        productManager.read();
        ordersManager.read();
        accountManager.add(new Account("admin","admin","admin"));
        while (true){
            System.out.println("1. login \n"
                    + "2. register \n"
                    + "3. thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    Account newAccoutn = accountManager.create();
                    accountManager.add(newAccoutn);
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void login() {
        System.out.println("Nhập tài khoản: ");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        Account account = accountManager.checkLogin(name, password);
        if (account != null) {
                Menu(account);
        } else System.out.println("đăng nhập bị lỗi");
    }

    public static void main(String[] args) {
        BaseMenu();
    }
}
