package src.IOManager;

import src.model.Account;
import src.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOAccount {
    static File file = new File("accounts.txt");

    public static void write(List<Account> accounts) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Account> read() {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<Account>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
