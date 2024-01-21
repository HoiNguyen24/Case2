package src.IOManager;

import src.model.PhotoDecal;
import src.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IODecal {
    static File file = new File("decals.txt");

    public static void write(List<PhotoDecal> products) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<PhotoDecal> read() {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<PhotoDecal>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
