package lesson11;

public class Lesson_11_1 {
  public static void main(String[] args) {
    // Задание 1
    // Создание животных
    Animal.Dog Bobik = new Animal.Dog("Bobik");
    Animal.Dog Sharik = new Animal.Dog("Sharik");
    Animal.Cat Moska = new Animal.Cat("Moska");
    Animal.Cat Vaska = new Animal.Cat("Vaska");
    Animal.Cat Rizhik = new Animal.Cat("Rizhik");

    // Собаки
    Bobik.run(150); // Бобик пробежал 150 м.
    Bobik.swim(5); // Бобик проплыл 5 м.
    Sharik.run(600); // Шарик не может пробежать больше 500 м.
    // Коты
    Moska.run(100); // Моська пробежал 100 м.
    Moska.swim(10); // Моська не умеет плавать.
    Vaska.run(220); // Васька не может пробежать больше 200 м.
    Vaska.swim(1); // Васька не умеет плавать.
    Rizhik.run(200); // Рыжик пробежал 200 м.

    // Массив котов
    Animal.Cat[] cats = {Moska, Vaska, Rizhik};
    // Первоначальное количество еды в миске
    Animal.Cat.Bowl bowl = new Animal.Bowl(31);
    // Коты кушают из миски
    for (Animal.Cat cat : cats) {
      cat.eat(bowl);
    }

    // Сытость котов
    for (Animal.Cat cat : cats) {
      System.out.println(cat.name + " - сытость: " + cat.satiety);
    }

    // Добавление еды в миску
    bowl.addFood(10);

    // Вывод количества животных
    System.out.println("Всего животных: " + Animal.getAnimalCount());
    System.out.println("Всего собак: " + Animal.Dog.getDogCount());
    System.out.println("Всего котов: " + Animal.Cat.getCatCount());
  }

  /*
  Задание 1
  Создать классы Собака и Кот с наследованием от класса Животное.

  Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
  Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); Бобик пробежал 150 м.);

  У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать,
  собака 10 м.).

  Добавить подсчет созданных котов, собак и животных,

  Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты:
  - Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
  а кот пытается покушать 15-20).
  - Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило
  еды), сытость true.
  - Считаем, что если коту мало еды в миске, то он её просто не трогает, то есть не может быть наполовину сыт
  (это сделано для упрощения логики программы).
  - Создать массив котов и миску с едой, попросить всех котов покушать из этой миски и потом вывести информацию о
  сытости котов в консоль.
  - Добавить метод, с помощью которого можно было бы добавлять еду в миску.
  */

  public abstract static class Animal {
    public String name;
    private static int animalCount = 0;

    public Animal(String name) {
      this.name = name;
      animalCount++;
    }

    public static int getAnimalCount() {
      return animalCount;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static class Dog extends Animal {
      private static int dogCount = 0;

      public Dog(String name) {
        super(name);
        dogCount++;
      }

      private static int getDogCount() {
        return dogCount;
      }

      @Override
      public void run(int distance) {
        if (distance <= 500) {
          System.out.println(name + " пробежал " + distance + " м.");
        } else {
          System.out.println(name + " не может пробежать больше 500 м.");
        }
      }

      @Override
      public void swim(int distance) {
        if (distance <= 10) {
          System.out.println(name + " проплыл " + distance + " м.");
        } else {
          System.out.println(name + " не может проплыть больше 10 м.");
        }
      }
    }

    public static class Cat extends Animal {
      private static int catCount = 0;
      public boolean satiety;

      public Cat(String name) {
        super(name);
        catCount++;
        this.satiety = false;
      }

      private static int getCatCount() {
        return catCount;
      }

      @Override
      public void run(int distance) {
        if (distance <= 200) {
          System.out.println(name + " пробежал " + distance + " м.");
        } else {
          System.out.println(name + " не может пробежать больше 200 м.");
        }
      }

      @Override
      public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
      }

      public void eat(Bowl bowl) {
        if (bowl.foodInBowl >= 15) {
          bowl.foodInBowl -= 15;
          satiety = true;

          System.out.println(
              name + " покушал из миски. В миске осталось " + bowl.foodInBowl + " еды.");
        } else {
          System.out.println(name + " не смог покушать из миски. Мало еды.");
        }
      }
    }

    public static class Bowl {
      public int foodInBowl;

      public Bowl(int foodInBowl) {
        this.foodInBowl = foodInBowl;
      }

      public void addFood(int count) {
        foodInBowl += count;
        System.out.println(
            "В миску добавлено " + count + " еды. Сейчас в ней " + foodInBowl + " еды.");
      }
    }
  }
}
