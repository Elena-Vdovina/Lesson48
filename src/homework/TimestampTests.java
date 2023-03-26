package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import register.ReceiptLine;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TimestampTests {
  @DisplayName("Ловим некорректный ввод часов <0")
  @Test
  public void negativeHours(){
    assertThrowsExactly(IllegalArgumentException.class, () -> new Timestamp(-1, 1));
  }

}
