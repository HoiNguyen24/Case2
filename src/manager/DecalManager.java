package src.manager;

import src.model.Clothes;
import src.model.PhotoDecal;
import src.validate.DecalValidate;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecalManager {
    ArrayList<PhotoDecal> photos = new ArrayList<PhotoDecal>();

    static Scanner scanner = new Scanner(System.in);
    StringBuffer stringBuffer = new StringBuffer();

    public void add(PhotoDecal photoDecal){
        photos.add(photoDecal);
    }
    public void delete(int index){
        photos.remove(index);
    }
    public void edit(PhotoDecal photoDecal,int index){
        photos.set(index,photoDecal);
    }
    public void display(){
        for(PhotoDecal photoDecal : photos){
            System.out.println(photoDecal);
        }
    }
    public void displayByDay(){
        Pattern pattern = Pattern.compile("^[0-9]{4}\s[0-9]{1,2}\s[0-9]{1,2}$");
        System.out.println("Nhập ngày tháng(VD: 2022 02 21)");
        String date = scanner.nextLine();
        Matcher matcher = pattern.matcher(date);
        if(matcher.find()){
            for(int  i = 0 ; i < photos.size();i++){
                PhotoDecal photo = photos.get(i);
                for(int j = 0 ; j < photo.getDates().getSize();j++){
                    if(date.equals(photo.getDates().getDates(j).toString()))
                        System.out.println(photo.getDates().getDates(j));
                }
            }
        }
    }
    public PhotoDecal create(){
        String name = DecalValidate.Name(photos);
        String code = DecalValidate.Code(photos);
        System.out.println("Nhập chiều rộng: ");
        double width = DecalValidate.unit(photos);
        System.out.println("Nhập chiều dài: ");
        double height = DecalValidate.unit(photos);
        System.out.println("Nhập giá tiền: ");
        long price = Long.parseLong(String.valueOf(DecalValidate.unit(photos)));
        System.out.println("Nhập số lượng: ");
        long quantity = Long.parseLong(String.valueOf(DecalValidate.unit(photos)));
        return new PhotoDecal(name,code,width,height,price,quantity);
    }
//    find by code
    public int FindByCode(String code){
        for (int i = 0; i < photos.size(); i++) {
            if(code.equals(photos.get(i)))
                return i;
        }
        return -1;
    }
    public void ChooseDelete(){
             display();
        System.out.println("Nhập mã của hình muốn xóa: ");
        stringBuffer.append(scanner.nextLine());
        if(FindByCode(stringBuffer.toString()) == -1)
            System.out.println("không tìm thấy hình muốn xóa");
        else
            delete(FindByCode(stringBuffer.toString()));
        stringBuffer.delete(0,stringBuffer.length() - 1);
    }
    public void ChooseEdit(){
        display();
        System.out.println("Nhập mã hình muốn sửa: ");
        stringBuffer.append(scanner.nextLine());
        if(FindByCode(stringBuffer.toString()) == -1)
            System.out.println("không tìm thấy hình muốn sửa");
        else
            edit(create(),FindByCode(stringBuffer.toString()));
        stringBuffer.delete(0,stringBuffer.length()-1);
    }
    public void addQuantity() {
        display();
        stringBuffer.delete(0, stringBuffer.length() - 1);
        System.out.println("nhập mã hình muốn: ");
        stringBuffer.append(scanner.nextLine());
        int index = FindByCode(stringBuffer.toString());
        if (index == -1)
            System.out.println("không tìm thấy hình");
        else {
            long quantity;
            while (true) {
                System.out.println("Nhập số hình muốn thêm: ");
                try {
                    quantity = Long.parseLong(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Nhập lại");
                }
            }
            photos.get(index).setQuantity(photos.get(index).getQuantity() + quantity);
            photos.get(index).getDates().add(System.currentTimeMillis());
        }
    }
}
