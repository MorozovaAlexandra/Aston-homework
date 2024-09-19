package lesson5;

import java.util.Arrays;

public class Lesson_5 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSum(5, 5));
        checkNumber(-2);
        System.out.println(isNegativeNumber(-5));
        printStringnTimes("QA Engineer Java", 2);
        System.out.println(isLeapYear(2024));
        replaceZerosAndOnes(new int[]{1, 0, 0, 1, 1});
        fillArray();
        multiply();
        diagonalMatrix();
        System.out.println(Arrays.toString(createArray(5, 3)));

    }

    /*
    Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова:
    Orange, Banana, Apple.
     */
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /*
    Создайте метод checkSumSign(), в теле которого объявите две int переменные а и в, и инициализируйте
    их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их
    сумма больше или равна 0, то вывести в консоль сообщение "Сумма положительная", в противном случае
    "Сумма отрицательная"
     */
    public static void checkSumSign() {
        int a = 3;
        int b = -3;

        if ((a + b) >= 0) {
            System.out.println("Сумма положительна");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    /*
    Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым
    значением. Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение "Красный",
     если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то "Желтый", если больше 100
     (100 исключительно) "Зеленый"
     */
    public static void printColor() {
        int value = 50;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    /*
    Создайте метод соmраreNumbers(), в теле которого объявите две int переменные а и b, и инициализируйте
    их любыми значениями, которыми захотите. Если а больше или равно в, то необходимо вывести в консоль
    сообщение "а >= b", в противном случае "а < b"
     */
    public static void compareNumbers() {
        int a = 2;
        int b = -3;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    /*
    Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10
    до 20 (включительно), если да вернуть true, в противном случае false
     */
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    /*
    Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " является положительным");
        } else {
            System.out.println("Число " + number + " является отрицательным");
        }
    }

    /*
    Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    если число отрицательное, и вернуть false если положительное. Замечание: ноль считаем положительным
    числом.
     */
    public static boolean isNegativeNumber(int number) {
        return number < 0;
    }

    /*
    Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в
    консоль указанную строку, указанное количество раз.
     */
    public static void printStringnTimes (String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    /*
    Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный true,
    не високосный false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й
    високосный.
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /*
    Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [1, 1, 0, 0, 1, 0, 1, 1, 0, 0].
    С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
    public static void replaceZerosAndOnes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 12345678... 100.
     */
    public static void fillArray () {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    Задать массив [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1] пройти по нему циклом, и числа меньшие 6 умножить
    на 2.
     */
    public static void multiply () {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
    цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе
    сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов
    равны, то есть [0][0], [1][1], [2][2], ..., [n][n].
     */
    public static void diagonalMatrix () {
        int[][] matrix = new int[7][7];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
    типа int длиной len, каждая ячейка которого равна initialValue.
     */
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
