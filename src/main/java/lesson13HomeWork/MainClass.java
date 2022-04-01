package lesson13HomeWork;

import java.util.concurrent.CountDownLatch;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch cdl1 = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch cdl2 = new CountDownLatch(CARS_COUNT);

    public static boolean win = false;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Car[] cars = new Car[CARS_COUNT];
        Race race = new Race(new Road(60), new Tunnel(cars.length/2), new Road(40));

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            new Thread(() -> {
                cars[finalI].run();
                cdl1.countDown();
            }).start();
        }

        try {
            cdl1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        for (int i = 0; i < cars.length; i++) {
            int finalI = i;
            new Thread(() -> {
                cars[finalI].race();
                //Определение победителя
                if (!win && cars[finalI].getLastStageDone() == race.getStages().size()) {
                    System.out.println(cars[finalI].getName() + " WIN!!!");
                    win = true;
                }
                cdl2.countDown();
            }).start();
        }

        try {
            cdl2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

