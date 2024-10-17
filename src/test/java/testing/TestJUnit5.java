package testing;

import lesson14.Lesson14;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestJUnit5 {
  @Test
  @DisplayName("Вычисление факториала для положительного числа")
  public void testFactorialPositive() {
    int actualResult1 = Lesson14.calculateFactorial(3);
    assertEquals(6, actualResult1);
  }

  @Test
  @DisplayName("Вычисление факториала для 0")
  public void testFactorialZero() {
    int actualResult2 = Lesson14.calculateFactorial(0);
    assertEquals(1, actualResult2);
  }

  @Test
  @DisplayName("Вычисление факториала для отрицательного числа")
  public void testFactorialNegative() {
    assertThrows(IllegalArgumentException.class, () -> Lesson14.calculateFactorial(-3));
  }
}
