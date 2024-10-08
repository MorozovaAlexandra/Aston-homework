package lesson10;

import java.util.ArrayList;
import java.util.List;

public class Lesson_10 {
  public static void main(String[] args) {
    Employee employee =
        new Employee(
            "Иванов Иван Иванович",
            "экономист",
            "ivanov30@gmail.com",
            "+375333333333",
            3500.54,
            30);
    employee.information();

    Person[] persArray = new Person[5];
    persArray[0] =
        new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
    persArray[1] =
        new Person("Voronina Anna", "Meneger", "voronina@mailbox.com", "+3753332222222", 45000, 28);
    persArray[2] =
        new Person(
            "Galustyn Mikhail", "Comedian", "galustyn@mailbox.com", "+77777777777", 1000000, 44);
    persArray[3] =
        new Person("Anna Asti", "Singer", "anasti@mailbox.com", "+71111111111", 2000000, 34);
    persArray[4] =
        new Person("Kristina Asmus", "Actor", "asmusk@mailbox.com", "+72222222222", 1500000, 36);

    for (Person person : persArray) {
      System.out.println(person);
    }

    Park park = new Park("Disneyland");
    park.addAttraction("Roller Coaster", "09:00 - 18:00", 5.0);
    park.addAttraction("Ferris Wheel", "09:00 - 20:00", 4.0);
    park.addAttraction("Superball", "10:00 - 19:00", 4.5);

    park.displayAttractions();
  }

  /*
  Создать класс "Сотрудник" с полями: ФИО, должность, еmail, телефон, зарплата, возраст.
  Конструктор класса должен заполнять эти поля при создании объекта. Внутри класса «Сотрудник»
  написать метод, который выводит информацию об объекте в консоль.
   */
  public static class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final double salary;
    private final int age;

    public Employee(
        String fullName,
        String position,
        String email,
        String phoneNumber,
        double salary,
        int age) {
      this.fullName = fullName;
      this.position = position;
      this.email = email;
      this.phoneNumber = phoneNumber;
      this.salary = salary;
      this.age = age;
    }

    public void information() {
      System.out.println("ФИО: " + fullName);
      System.out.println("должность: " + position);
      System.out.println("email: " + email);
      System.out.println("телефон: " + phoneNumber);
      System.out.println("зарплата: " + salary);
      System.out.println("возраст: " + age);
    }
  }

  /*
  Создать массив из 5 сотрудников.
  */
  public static class Person {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final double salary;
    private final int age;

    public Person(
        String fullName,
        String position,
        String email,
        String phoneNumber,
        double salary,
        int age) {
      this.fullName = fullName;
      this.position = position;
      this.email = email;
      this.phoneNumber = phoneNumber;
      this.salary = salary;
      this.age = age;
    }

    public String toString() {
      return "Name: "
          + fullName
          + ", Position: "
          + position
          + ", Email: "
          + email
          + ", Phone: "
          + phoneNumber
          + ", Salary: "
          + salary
          + ", Age: "
          + age;
    }
  }

  /*
  Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах,
  времени их работы и стоимости.
   */
  public static class Park {
    private final String title;
    private final List<Attraction> attractions;

    public Park(String title) {
      this.title = title;
      this.attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String workingHours, double price) {
      Attraction attraction = new Attraction(name, workingHours, price);
      attractions.add(attraction);
    }

    public void displayAttractions() {
      System.out.println("Attractions in " + title + ":");
      for (Attraction attraction : attractions) {
        System.out.println(attraction);
      }
    }

    public static class Attraction {
      private final String name;
      private final String workingHours;
      private final double price;

      public Attraction(String name, String workingHours, double price) {
        this.name = name;
        this.workingHours = workingHours;
        this.price = price;
      }

      @Override
      public String toString() {
        return "Attraction (name='"
            + name
            + "', workingHours="
            + workingHours
            + ", price="
            + price
            + ")";
      }
    }
  }
}
