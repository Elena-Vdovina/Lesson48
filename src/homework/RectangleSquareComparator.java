package homework;

import org.junit.jupiter.api.DisplayName;

import java.util.Comparator;

// Создать класс Rectangle (прямоугольник), которому в конструкторе нужно передавать длину и ширину.
// Написать компаратор, который сравнивает прямоугольники по площади.
// Написать тесты для этого компаратора.
public class RectangleSquareComparator implements Comparator<Rectangle> {

  @Override
  public int compare(Rectangle r1, Rectangle r2) {
    return r1.getSquare() - r2.getSquare();
  }
}
