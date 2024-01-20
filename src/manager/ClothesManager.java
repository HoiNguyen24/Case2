package src.manager;

import src.model.Clothes;
import src.validate.ClothesValidate;

import java.util.ArrayList;
import java.util.Scanner;

public class ClothesManager {
    ArrayList<Clothes> clothes = new ArrayList<>();
    static StringBuffer stringBuffer = new StringBuffer();

    static Scanner scanner = new Scanner(System.in);
    public void add(Clothes newClothes){
        clothes.add(newClothes);
    }

    public void edit(Clothes newClothes,int index){
        clothes.set(index, newClothes);
    }
    public void delete(int index){
        clothes.remove(index);
    }

    public void display(){
        for (Clothes clothe :
             clothes) {
            System.out.println(clothe);
        }
    }
    public Clothes create(){
          String code = String.valueOf(ClothesValidate.Code(clothes));
          String name = String.valueOf(ClothesValidate.Name(clothes));
        System.out.println("Nhập loại: ");
        String type = scanner.nextLine();
        System.out.println("Nhập màu: ");
        String color = scanner.nextLine();
        System.out.println("Nhập giá");
        long price,quantity;
        while(true){
            try{
                price = Long.parseLong(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Nhập lại");
            }
        }
        System.out.println("Nhập số lượng: ");
        while(true){
            try{
                quantity = Long.parseLong(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Nhập lại");
            }
        }
        return new Clothes(name,type,color,price,quantity,code);
    }
//    Find by Clothes code
    public int FindbyCode(String code){
        for (int i = 0; i < clothes.size(); i++) {
            if(code.equals(clothes.get(i).getCode()))
                return i;
        }
        return -1;
    }
//    delete
    public void ChooseDelete(){
        display();
        System.out.println("Nhập mã hàng muốn xóa: ");
        stringBuffer.append(scanner.nextLine());
        if(FindbyCode(stringBuffer.toString()) == -1)
            System.out.println("không tìm thấy mã hàng muốn xóa");
        else delete(FindbyCode(stringBuffer.toString()));
    }
//    edit
    public void chooseEdit(){
        display();
        System.out.println("nhập mã hàng muốn sửa");
        stringBuffer.append(scanner.nextLine());
        if(FindbyCode(stringBuffer.toString()) == -1)
            System.out.println("không tìm thấy mã hàng muốn sửa");
        else edit(create(),FindbyCode(stringBuffer.toString()));
    }
//    Find by name


}
