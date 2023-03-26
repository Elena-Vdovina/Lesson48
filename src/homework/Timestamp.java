package homework;

// Создать класс Timestamp для хранения отметки времени (точки "часы:минуты").
// У класса должны быть методы "добавить часы" и "добавить минуты", принимающий количество часов
// (или минут) для добавления.
// В классе должен быть реализован интерфейс Comparable, который бы сравнивал отметки времени
// (раньше - меньше, позже - больше).
// Примечание: считаем, что корректные отметки времени находятся только в диапазоне от 00:00
// до 23:59
// Попытка добавить 1 минуту к отметке 23:59 должна приводить к установке времени на отметку 00:00.
// Написать тесты.
public class Timestamp {

  private String timeStamp;
  private int hours;
  private int minutes;

  public Timestamp(int hours, int minutes) {
    checkHours(hours);
    this.hours = hours;
    checkMinutes(minutes);
    this.minutes = minutes;
    writeTime(hours, minutes);

  }

  private void checkHours(int hours) {
    if (hours < 0 || hours > 23) {
      throw new IllegalArgumentException("Некорректное значение часов " + hours);
    }
  }

  private void writeTime(int hours, int minutes) {
    if (hours < 10) {
      this.timeStamp = "0" + this.hours + ":";
    } else {
      this.timeStamp = this.hours + ":";
    }
    if (minutes < 10) {
      this.timeStamp += "0" + this.minutes;
    } else {
      this.timeStamp += this.minutes;
    }
  }

  private void checkMinutes(int minutes) {
    if (minutes < 0 || minutes > 59) {
      throw new IllegalArgumentException("Некорректное значение минут " + minutes);
    }
  }

  public void addHours(int hours) {
    checkHours(hours);
    this.hours = this.hours + hours;
    if (this.hours == 24) {
      this.hours = 0;
    }
    if (this.hours > 24) {
      this.hours = this.hours - 24;
    }
    writeTime(this.hours, this.minutes);
  }

  public void addMinutes(int minutes) {
    checkMinutes(minutes);
    this.minutes = this.minutes + minutes;
    if (this.minutes == 60) {
      this.minutes = 0;
      this.hours = this.hours + 1;
    }
    if (this.minutes > 60) {
      this.minutes = this.minutes - 60;
      this.hours = this.hours + 1;
    }
    writeTime(this.hours, this.minutes);
  }
}
