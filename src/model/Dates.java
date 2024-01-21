package src.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Dates implements Serializable {
    ArrayList<Date> dates = new ArrayList<Date>();

    public  void add() {
        dates.add(new Date(System.currentTimeMillis()));
    }

    public int getSize() {
        return dates.size();
    }

    public Date getDates(int index) {
        return dates.get(index);
    }

    public void display() {
        for (Date date :
                dates) {
            System.out.println(date);
        }
    }

}
