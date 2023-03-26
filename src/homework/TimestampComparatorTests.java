package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimestampComparatorTests {
  private final Comparator<Timestamp> comparator = new TimestampComparator();

  @DisplayName("Сравниваем разные точки времени")
  @Test
  public void differentStamp() {
    Timestamp t1 = new Timestamp(1, 1);
    Timestamp t2 = new Timestamp(2, 2);

    int result1 = comparator.compare(t1, t2);
    int result2 = comparator.compare(t2, t1);

    assertTrue(result1 < 0);
    assertTrue(result2 > 0);
  }

  @DisplayName("Сравниваем равные точки времени")
  @Test
  public void equalStamp() {
    Timestamp t1 = new Timestamp(1, 1);
    Timestamp t2 = new Timestamp(1, 1);

    int result1 = comparator.compare(t1, t2);
    int result2 = comparator.compare(t2, t1);

    assertTrue(result1 == 0);
    assertTrue(result2 == 0);
  }

  @DisplayName("Сравниваем точки одного часа и разными минутами")
  @Test
  public void equalHoursDifferentMinutes() {
    Timestamp t1 = new Timestamp(1, 2);
    Timestamp t2 = new Timestamp(2, 1);

    int result1 = comparator.compare(t1, t2);
    int result2 = comparator.compare(t2, t1);

    assertTrue(result1 < 0);
    assertTrue(result2 > 0);
  }

  @DisplayName("Проверяем сортировку")
  @Test
  public void sort() {
    Timestamp t1 = new Timestamp(10, 20);
    Timestamp t2 = new Timestamp(10, 30);
    Timestamp t3 = new Timestamp(20, 30);
    Timestamp t4 = new Timestamp(5, 30);
    Timestamp t5 = new Timestamp(10, 10);

    List<Timestamp> actual = new ArrayList<>();
    actual.add(t1);
    actual.add(t2);
    actual.add(t3);
    actual.add(t4);
    actual.add(t5);

    List<Timestamp> expected = new ArrayList<>();
    expected.add(t4);
    expected.add(t5);
    expected.add(t1);
    expected.add(t2);
    expected.add(t3);

    actual.sort(comparator);

    assertEquals(expected, actual);
  }
}
