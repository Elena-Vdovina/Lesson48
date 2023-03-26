package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import register.ReceiptLine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TimestampTests {
  @DisplayName("Ловим некорректный ввод часов <0")
  @Test
  public void negativeHours() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp(-1, 1));
  }

  @DisplayName("Ловим некорректный ввод часов >23")
  @Test
  public void incorrectHours() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp(24, 1));
  }

  @DisplayName("Ловим некорректный ввод минут <0")
  @Test
  public void negativeMinutes() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp(1, -1));
  }

  @DisplayName("Ловим некорректный ввод минут >59")
  @Test
  public void incorrectMinutes() {
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp(1, 60));
  }

  @DisplayName("Проверяем конструктор")
  @Test
  public void construct() {
    Timestamp t1 = new Timestamp(1, 1);
    assertEquals(1, t1.getHours());
    assertEquals(1, t1.getMinutes());
    assertEquals("01:01", t1.getTimeStamp());
  }

  @DisplayName("Проверяем сеттер часов")
  @Test
  public void setHoursCheck() {
    Timestamp t1 = new Timestamp(1, 1);
    t1.setHours(5);
    assertEquals(5, t1.getHours());
    assertEquals("05:01", t1.getTimeStamp());
  }

  @DisplayName("Проверяем сеттер минут")
  @Test
  public void setMinutesCheck() {
    Timestamp t1 = new Timestamp(1, 1);
    t1.setMinutes(5);
    assertEquals(5, t1.getMinutes());
    assertEquals("01:05", t1.getTimeStamp());
  }

  @DisplayName("Проверяем добавление часов <24")
  @Test
  public void addHoursCheck1() {
    Timestamp t1 = new Timestamp(1, 1);
    t1.addHours(5);
    assertEquals(6, t1.getHours());
    assertEquals("06:01", t1.getTimeStamp());
  }

  @DisplayName("Проверяем добавление часов =24")
  @Test
  public void addHoursCheck2() {
    Timestamp t1 = new Timestamp(10, 1);
    t1.addHours(14);
    assertEquals(0, t1.getHours());
    assertEquals("00:01", t1.getTimeStamp());
  }

  @DisplayName("Проверяем добавление часов >24")
  @Test
  public void addHoursCheck3() {
    Timestamp t1 = new Timestamp(14, 1);
    t1.addHours(14);
    assertEquals(4, t1.getHours());
    assertEquals("04:01", t1.getTimeStamp());
  }

  @DisplayName("Проверяем добавление минут <60")
  @Test
  public void addMinutesCheck1() {
    Timestamp t1 = new Timestamp(1, 1);
    t1.addMinutes(5);
    assertEquals(6, t1.getMinutes());
    assertEquals("01:06", t1.getTimeStamp());
  }

  @DisplayName("Проверяем добавление минут =60")
  @Test
  public void addMinutesCheck2() {
    Timestamp t1 = new Timestamp(1, 28);
    t1.addMinutes(32);
    assertEquals(0, t1.getMinutes());
    assertEquals("02:00", t1.getTimeStamp());
  }
}
