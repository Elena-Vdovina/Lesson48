package homework;

import java.util.Comparator;

// В классе должен быть реализован интерфейс Comparable, который бы сравнивал отметки времени
// (раньше - меньше, позже - больше).
public class TimestampComparator implements Comparator<Timestamp> {

  @Override
  public int compare(Timestamp t1, Timestamp t2){
    if (t1.getHours()!= t2.getHours()){
      return t1.getHours()-t2.getHours();
    }
    return t1.getMinutes()- t2.getMinutes();
  }
}
