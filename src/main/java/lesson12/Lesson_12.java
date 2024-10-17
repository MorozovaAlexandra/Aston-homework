package lesson12;

public class Lesson_12 {
  public static void main(String[] args) {
    String[][] validArray = {
      {"1", "2", "3", "4"},
      {"5", "6", "7", "8"},
      {"9", "10", "11", "12"},
      {"13", "14", "15", "16"}
    };
    String[][] invalidArray = {
      {"1", "2", "3", "4"},
      {"5", "6", "7", "8"},
      {"9", "10", "11", "12"}
    };
    String[][] invalidArray2 = {
      {"1", "@", "3", "4"},
      {"5", "6", "7", "8"},
      {"9", "10", "11", "12"},
      {"13", "14", "15", "16"}
    };

    try {
      MyArray.Matrix(validArray);
    } catch (MyArraySizeException e) {
      System.err.println(e.getMessage());
    } catch (MyArrayDataException e) {
      System.err.println(e.getMessage() + (e.getRow() + 1) + " " + (e.getCol() + 1));
    }

    try {
      MyArray.Matrix(invalidArray);
    } catch (MyArraySizeException e) {
      System.err.println(e.getMessage());
    } catch (MyArrayDataException e) {
      System.err.println(e.getMessage() + (e.getRow() + 1) + " " + (e.getCol() + 1));
    }

    try {
      MyArray.Matrix(invalidArray2);
    } catch (MyArraySizeException e) {
      System.err.println(e.getMessage());
    } catch (MyArrayDataException e) {
      System.err.println(e.getMessage() + (e.getRow() + 1) + " " + (e.getCol() + 1));
    }
  }

  /*
  1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива
  другого размера необходимо бросить исключение MyArraySizeException.
  2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в
  каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
  должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
  3. В методе main() вызвать полученный метод, обработать возможные исключения МуArraySizeException и
  MyArrayDataException и вывести результат расчета.
   */
  public static class MyArraySizeException extends Exception {
    public MyArraySizeException(String massage) {
      super(massage);
    }
  }

  public static class MyArrayDataException extends Exception {
    private final int row;
    private final int col;

    public MyArrayDataException(String massage, int row, int col) {
      super(massage);
      this.row = row;
      this.col = col;
    }

    public int getRow() {
      return row;
    }

    public int getCol() {
      return col;
    }
  }

  public static class MyArray {
    public static void Matrix(String[][] Array) throws MyArraySizeException, MyArrayDataException {
      if (Array.length != 4 || Array[0].length != 4) {
        throw new MyArraySizeException("Размер массива должен быть 4*4");
      }

      int sum = 0;
      for (int i = 0; i < Array.length; i++) {
        for (int j = 0; j < Array[i].length; j++) {
          try {
            sum += Integer.parseInt(Array[i][j]);
          } catch (NumberFormatException e) {
            throw new MyArrayDataException("Некорректные данные в ячейке: ", i, j);
          }
        }
      }
      System.out.println("Сумма: " + sum);
    }
  }
}
