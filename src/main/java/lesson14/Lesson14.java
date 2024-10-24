package lesson14;

public class Lesson14 {
  public static void main(String[] args) {
    System.out.println(calculateFactorial(5));
    System.out.println(calculateFactorial(0));
    System.out.println(calculateFactorial(-5));
  }

  public static int calculateFactorial(int number) {
    int factorial = 1;

    if (number < 0) {
      throw new IllegalArgumentException("Для отрицательных чисел нельзя вычислить факториал");
    }

    if (number == 0) {
      return factorial;
    }

    for (int i = 1; i <= number; i++) {
      factorial *= i;
    }

    return factorial;
  }
}
