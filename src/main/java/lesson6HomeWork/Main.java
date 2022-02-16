package lesson6HomeWork;

public class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog();
        dog1.printInfo();
        dog1.run(450);
        dog1.swim(4);
        dog1.wagTail();

        Dog dog2 = new Dog("Мухтар", "немецкая овчарка");
        dog2.printInfo();
        dog2.run(550);
        dog2.swim(30);
        dog2.wagTail();

        Cat cat1 = new Cat("Василий", true);
        cat1.printInfo();
        cat1.purr();
        cat1.run(15);
        cat1.swim(40);

        Cat cat2 = new Cat();
        cat2.printInfo();
        cat2.purr();
        cat2.run(25);
        cat2.swim(2);

        System.out.printf("Количество всех животных: %d\n", Animal.count);
        System.out.printf("Количество собак: %d\n", Dog.count);
        System.out.printf("Количество котов: %d\n", Cat.count);

        Animal[] arrayOfAnimals = {dog1, dog2, cat1, cat2};

        Integer catCount = 0;
        Integer dogCount = 0;

        for (Animal animal : arrayOfAnimals) {
            if (animal instanceof Dog) {
                dogCount++;
            } else {
                catCount++;
            }
        }

        System.out.printf("Количество всех животных в массиве: %d\n", arrayOfAnimals.length);
        System.out.printf("Количество собак в массиве: %d\n", dogCount);
        System.out.printf("Количество котов в массиве: %d\n", catCount);

    }
}
