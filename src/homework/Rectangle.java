package homework;

// Создать класс Rectangle (прямоугольник), которому в конструкторе нужно передавать длину и ширину.
// Написать компаратор, который сравнивает прямоугольники по площади.
// Написать тесты для этого компаратора.
public class Rectangle {

  private final int length;
  private final int width;
  private final int square;

  public Rectangle(int length, int width) {
    this.length = length;
    this.width = width;
    this.square = length * width;
  }

  public int getLength() {
    return length;
  }

  public int getWidth() {
    return width;
  }

  public int getSquare() {
    return square;
  }

  @Override
  public String toString() {
    return "Rectangle square = " + square + ", length = " + length + ", width = " + width;
  }
}
