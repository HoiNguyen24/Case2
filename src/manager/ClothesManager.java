package src.manager;

import src.IOManager.IOClothes;
import src.model.Clothes;
import src.model.Dates;
import src.validate.ClothesValidate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClothesManager {
    ArrayList<Clothes> clothes = new ArrayList<>();
    static StringBuffer stringBuffer = new StringBuffer();

    public static Scanner scanner = new Scanner(System.in);
    public void add(Clothes newClothes){
        clothes.add(newClothes);
        clothes.get(clothes.size()-1).addHistory();
    }

    public void edit(Clothes newClothes,int index){
        clothes.set(index, newClothes);
    }
    public void delete(int index){
        clothes.remove(index);
    }

    public void write(){
        IOClothes.write(clothes);
    }
    public void read(){
        clothes = IOClothes.read();
    }
    public void display(){
        for (Clothes clothe :
             clothes) {
            System.out.println(clothe);
        }
    }
    public void displayHistory(){
        String code = scanner.nextLine();
        Clothes clothe = clothes.get(FindbyCode(code));
        clothe.getDates().display();
    }
    public void displayAllHistory(){
        for(Clothes cloth: clothes){
            System.out.println(cloth.getName()+":");
            cloth.getDates().display();
        }
    }
    public void displayByDay(){
        Pattern pattern = Pattern.compile("^[0-9]{4}\s[0-9]{1,2}\s[0-9]{1,2}$");
        System.out.println("Nhập ngày tháng(VD: 2022 02 21)");
        String date = scanner.nextLine();
        Matcher matcher = pattern.matcher(date);
        if(matcher.find()){
            for(int  i = 0 ; i < clothes.size();i++){
                Clothes cloth = clothes.get(i);
                for(int j = 0 ; j < cloth.getDates().getSize();j++){
                    if(date.equals(cloth.getDates().getDates(j).toString()))
                        System.out.println(cloth.getDates().getDates(j));
                }
            }
        }
    }
    public  void findByCode(){
        System.out.println("nhập mã code áo muốn tìm: ");
        String code = scanner.nextLine();
        for(Clothes cloth: clothes){
            if(cloth.getCode().equals(code)){
                System.out.println(cloth);
                break;
            }
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
        return new Clothes(name,type,color,price,quantity,code,new Dates());
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
    public void addQuantity(){
        display();
        stringBuffer.delete(0,stringBuffer.length());
        System.out.println("nhập mã áo phẩm muốn: ");
        stringBuffer.append(scanner.nextLine());
        int index = FindbyCode(stringBuffer.toString());
        if( index == -1)
            System.out.println("không tìm thấy áo");
        else {
            long quantity;
            while(true){
                System.out.println("Nhập số áo muốn thêm: ");
                try{
                    quantity = Long.parseLong(scanner.nextLine());
                    break;
                }catch (Exception e){
                    System.out.println("Nhập lại");
                }
            }
            clothes.get(index).setQuantity(clothes.get(index).getQuantity() + quantity);
            clothes.get(index).addHistory();
        }
    }
}
