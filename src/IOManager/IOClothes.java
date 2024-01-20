package src.IOManager;

import src.model.Clothes;
import src.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOClothes {
    static File file = new File("clothes.txt");

    public static void write(List<Clothes> products){
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(products);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Clothes> read(){
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<Clothes>) objectInputStream.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
