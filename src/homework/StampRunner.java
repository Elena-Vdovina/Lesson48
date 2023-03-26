package homework;

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

  }
}
