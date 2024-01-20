package src.model;

import java.sql.Date;
import java.util.ArrayList;

public class Dates {
     ArrayList<Date> dates = new ArrayList<Date>();

     public void add(long date){
         add(date);
     }
     public int getSize(){
         return dates.size();
     }

    public Date getDates(int index) {
        return dates.get(index);
    }

    public void display(){
         for (Date date:
              dates) {
             System.out.println(dates);
         }
     }

}
