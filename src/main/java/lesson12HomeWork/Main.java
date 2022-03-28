package lesson12HomeWork;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) throws InterruptedException {

        method1();
        method2();

    }

    public static void method1() {

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }

        System.out.printf("Метод 1 - %s\n", System.currentTimeMillis() - a);

    }

    public static void method2() throws InterruptedException {

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        Thread t1 = new Thread( () -> {
            for (int i = 0; i < HALF; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
            }
        });

        Thread t2 = new Thread( () -> {
            for (int i = HALF; i < SIZE; i++) {
                arr2[i - HALF] = (float) (arr2[i - HALF] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.printf("Метод 2 - %s\n", System.currentTimeMillis() - a);

    }

}
