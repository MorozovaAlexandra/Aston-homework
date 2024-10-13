package lesson11;

public class Lesson_11_2 {

  public static void main(String[] args) {

    // Задание 2
    lesson11.Lesson_11_2.Shape.Circle Circle =
        new lesson11.Lesson_11_2.Shape.Circle(5, "Красный", "Черный");
    lesson11.Lesson_11_2.Shape.Rectangle Rectangle =
        new lesson11.Lesson_11_2.Shape.Rectangle(5, 3, "Синий", "Белый");
    lesson11.Lesson_11_2.Shape.Triangle Triangle =
        new lesson11.Lesson_11_2.Shape.Triangle(5, 4, 3, "Желтый", "Зеленый");
    Circle.print();
    Rectangle.print();
    Triangle.print();
  }

  /*
  Задание 2
  Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник,
  треугольник.
  Задать для каждой фигуры цвет заливки и цвет границы.
  Результат полученных характеристик [Периметр, площадь, цвет фона, цвет границ] по каждой фигуре вывести в консоль.
  Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.
   */
  interface Shape {
    String getFillColor();

    String getBorderColor();

    double area();

    default double perimetr() {
      return 0;
    }

    default void print() {
      System.out.println(getClass().getSimpleName());
      System.out.println("Цвет фигуры: " + getFillColor());
      System.out.println("Цвет контура: " + getBorderColor());
      System.out.println("Площадь фигуры: " + area());
      System.out.println("Периметр фигуры: " + perimetr());
    }

    class Circle implements lesson11.Lesson_11_2.Shape {
      private static double radius;
      private static String fillColor;
      private static String borderColor;

      public Circle(double radius, String fillColor, String borderColor) {
        Circle.radius = radius;
        Circle.fillColor = fillColor;
        Circle.borderColor = borderColor;
      }

      @Override
      public String getFillColor() {
        return fillColor;
      }

      @Override
      public String getBorderColor() {
        return borderColor;
      }

      @Override
      public double area() {
        return Math.PI * radius * radius;
      }

      @Override
      public double perimetr() {
        return 2 * Math.PI * radius;
      }
    }

    class Rectangle implements lesson11.Lesson_11_2.Shape {
      private static double length;
      private static double width;
      private static String fillColor;
      private static String borderColor;

      public Rectangle(double length, double width, String fillColor, String borderColor) {
        Rectangle.length = length;
        Rectangle.width = width;
        Rectangle.fillColor = fillColor;
        Rectangle.borderColor = borderColor;
      }

      @Override
      public String getFillColor() {
        return fillColor;
      }

      @Override
      public String getBorderColor() {
        return borderColor;
      }

      @Override
      public double area() {
        return length * width;
      }

      @Override
      public double perimetr() {
        return 2 * (length + width);
      }
    }

    class Triangle implements lesson11.Lesson_11_2.Shape {
      private static double a;
      private static double b;
      private static double c;
      private static String fillColor;
      private static String borderColor;

      public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        Triangle.a = a;
        Triangle.b = b;
        Triangle.c = c;
        Triangle.fillColor = fillColor;
        Triangle.borderColor = borderColor;
      }

      @Override
      public String getFillColor() {
        return fillColor;
      }

      @Override
      public String getBorderColor() {
        return borderColor;
      }

      @Override
      public double area() {
        double p = perimetr() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
      }

      @Override
      public double perimetr() {
        return a + b + c;
      }
    }
  }
}
