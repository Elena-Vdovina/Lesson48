package homework;

import java.util.ArrayList;
import java.util.List;

public class StampRunner {
  public static void main(String[] args) {
    Timestamp t1=new Timestamp(6, 5);
    System.out.println(t1);
    t1.setHours(10);
    t1.setMinutes(54);
    System.out.println(t1);
    t1.addHours(20);
    System.out.println(t1);
    t1.addMinutes(6);
    System.out.println(t1);

    List<Timestamp> stamps=new ArrayList<>();
    stamps.add(new Timestamp(10,20));
    stamps.add(new Timestamp(10,30));
    stamps.add(new Timestamp(20,30));
    stamps.add(new Timestamp(5,30));
    stamps.add(new Timestamp(10,10));

    stamps.sort(new TimestampComparator());

    for (Timestamp t:stamps){
      System.out.println(t);
    }
  }
}
