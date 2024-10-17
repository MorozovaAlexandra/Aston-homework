package lesson13;

/*
 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список
 уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается
 каждое слово. (реализовать с использованием коллекций)
*/
import java.util.HashMap;
import java.util.Map;

public class Task1 {
  public static void main(String[] args) {

    String[] words = {
      "Zero", "One", "Two", "Two", "Three", "Three", "Three", "Four", "Four", "Four", "Four"
    };

    Map<String, Integer> wordCount = new HashMap<>();

    for (String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    System.out.println("Уникальные слова и их количества:");
    for (Map.Entry<String, Integer> e : wordCount.entrySet()) {
      System.out.println(e.getKey() + ": " + e.getValue());
    }
  }
}
