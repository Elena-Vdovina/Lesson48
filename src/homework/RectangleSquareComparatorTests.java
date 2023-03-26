package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

  @DisplayName("Сравниваем равные прямоугольники с разной длиной")
  @Test
  public void equalRectangleDifferentLength() {
    Rectangle r1 = new Rectangle(1, 2);
    Rectangle r2 = new Rectangle(2, 1);

    int result1 = comparator.compare(r1, r2);
    int result2 = comparator.compare(r2, r1);

    assertTrue(result1 < 0);
    assertTrue(result2 > 0);
  }

  @DisplayName("Проверяем сортировку")
  @Test
  public void sort() {
    Rectangle r1 = new Rectangle(2, 2);
    Rectangle r2 = new Rectangle(2, 1);
    Rectangle r3 = new Rectangle(1, 2);
    Rectangle r4 = new Rectangle(1, 1);

    List<Rectangle> actual = new ArrayList<>();
    actual.add(r1);
    actual.add(r2);
    actual.add(r3);
    actual.add(r4);

    List<Rectangle> expected = new ArrayList<>();
    expected.add(r4);
    expected.add(r3);
    expected.add(r2);
    expected.add(r1);

    actual.sort(comparator);

    assertEquals(expected, actual);
  }
}
