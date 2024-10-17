package lesson13;

/*
 Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
 искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
 (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
  public static void main(String[] args) {
    TelDirectory telDir = new TelDirectory();
    TelDirectory.add("Пупкин", "46-23-04");
    TelDirectory.add("Соколова", "44-11-32");
    TelDirectory.add("Пупкин", "44-05-45");
    TelDirectory.add("Иванов", "46-98-00");
    TelDirectory.add("Зайцева", "46-00-04");

    System.out.println(telDir.get("Пупкин"));
    System.out.println(telDir.get("Соколова"));
    System.out.println(telDir.get("Иванов"));
    System.out.println(telDir.get("Зайцева"));
    System.out.println(telDir.get("Морозова"));
  }

  public static class TelDirectory {
    static Map<String, List<String>> contacts;

    public TelDirectory() {
      contacts = new HashMap<>();
    }

    public static void add(String lastName, String phoneNumber) {
      contacts.putIfAbsent(lastName, new ArrayList<>());
      contacts.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
      return contacts.getOrDefault(lastName, null);
    }
  }
}
