package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

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
}
