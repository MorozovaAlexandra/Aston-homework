package testing;

import jdk.jfr.Description;
import lesson14.Lesson14;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestTestNG {
  @Test
  @Description("Вычисление факториала для положительного числа")
  public void testFactorialPositive() {
    int actualResult1 = Lesson14.calculateFactorial(3);
    assertEquals(actualResult1, 6);
  }

  @Test
  @Description("Вычисление факториала для 0")
  public void testFactorialZero() {
    int actualResult2 = Lesson14.calculateFactorial(0);
    assertEquals(actualResult2, 1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  @Description("Вычисление факториала для отрицательного числа")
  public void testFactorialNegative1() {
    Lesson14.calculateFactorial(-3);
  }
}
