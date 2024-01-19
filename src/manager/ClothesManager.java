package src.manager;

import src.model.Clothes;
import src.validate.ClothesValidate;

import java.util.ArrayList;
import java.util.Scanner;

public class ClothesManager {
    ArrayList<Clothes> clothes = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    public void add(Clothes newClothes){
        clothes.add(newClothes);
    }
    public void create(){
          String code = String.valueOf(ClothesValidate.Code(clothes));
          String name = String.valueOf(ClothesValidate.Name(clothes));
        System.out.println("Nhập loại: ");
        String type = scanner.nextLine();
        System.out.println("Nhập màu: ");
        String color = scanner.nextLine();
        System.out.println("Nhập giá");
        while(true){
            try{
                long price = Long.parseLong(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Nhap lai");
            }
        }



    }
}
