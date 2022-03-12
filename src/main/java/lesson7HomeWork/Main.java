package lesson7HomeWork;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rnd = new Random();

        Cat[] arr = new Cat[5];

        for (int i = 0; i < arr.length; i++) {

            arr[i] = new Cat("Cat" + (i+1), rnd.nextInt(10) + 1);

            arr[i].info();

        }

        Plate bigPlate = new Plate(20);
        bigPlate.info();

        for (Cat cat : arr) {

            System.out.println("------------");
            cat.info();
            cat.eat(bigPlate);
            cat.info();
            bigPlate.info();

        }

        bigPlate.increaseFood(30);
        bigPlate.info();

    }

}
