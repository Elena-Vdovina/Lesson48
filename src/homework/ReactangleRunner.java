package homework;

import java.util.ArrayList;
import java.util.List;

public class ReactangleRunner {
  public static void main(String[] args) {
    List<Rectangle> rectangles = new ArrayList<>();
    rectangles.add(new Rectangle(5, 6));
    rectangles.add(new Rectangle(2, 15));
    rectangles.add(new Rectangle(7, 6));
    rectangles.add(new Rectangle(4, 5));

    rectangles.sort(new RectangleSquareComparator());

    for (Rectangle r : rectangles) {
      System.out.println(r);
    }
  }
}
