package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Создать класс Rectangle (прямоугольник), которому в конструкторе нужно передавать длину и ширину.
// Написать компаратор, который сравнивает прямоугольники по площади.
// Написать тесты для этого компаратора.
public class RectangleSquareComparatorTests {

  private final Comparator<Rectangle> comparator = new RectangleSquareComparator();

  @DisplayName("Сравниваем разные прямоугольники")
  @Test
  public void differentRectangle() {
    Rectangle r1 = new Rectangle(1, 1);
    Rectangle r2 = new Rectangle(2, 2);

    int result1 = comparator.compare(r1, r2);
    int result2 = comparator.compare(r2, r1);

    assertTrue(result1 < 0);
    assertTrue(result2 > 0);
  }

  @DisplayName("Сравниваем равные прямоугольники")
  @Test
  public void equalRectangle() {
    Rectangle r1 = new Rectangle(1, 1);
    Rectangle r2 = new Rectangle(1, 1);

    int result1 = comparator.compare(r1, r2);
    int result2 = comparator.compare(r2, r1);

    assertTrue(result1 == 0);
    assertTrue(result2 == 0);
  }

}
