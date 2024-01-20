package src.manager;

import src.model.PhotoDecal;
import src.validate.DecalValidate;

import java.util.ArrayList;
import java.util.Scanner;

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
    public PhotoDecal create(){
        String name = DecalValidate.Name(photos);
        String code = DecalValidate.Code(photos);
        System.out.println("Nhập chiều rộng: ");
        double width = DecalValidate.unit(photos);
        System.out.println("Nhập chiều dài: ");
        double height = DecalValidate.unit(photos);
        System.out.println("Nhập giá tiền");
        long price = Long.parseLong(String.valueOf(DecalValidate.unit(photos)));
        return new PhotoDecal(name,code,width,height,price);
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
}
