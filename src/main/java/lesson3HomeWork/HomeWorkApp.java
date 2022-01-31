package lesson3HomeWork;

import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp {

    private static Random rnd = new Random();

    public static void main(String[] args) {

        System.out.println("Task 1");
        task1(8);
        System.out.println();

        System.out.println("Task 2");
        task2();
        System.out.println();

        System.out.println("Task 3");
        task3();
        System.out.println();

        System.out.println("Task 4");
        task4(7);
        System.out.println();

        System.out.println("Task 5");
        System.out.println(Arrays.toString( task5(7, -1)));
        System.out.println();

        System.out.println("Task 6");
        task6(20);
        System.out.println();

        System.out.println("Task 7");
        int[] array = new int[]{1, 2, 1, 2, 2};
        System.out.println(checkBalance(array));
        System.out.println();

        System.out.println("Task 8");
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(moveArrayElementsNTimes(array1, -9)));

    }


//    1. Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

    private static void task1(int arrayLength) {

        int[] array = new int[arrayLength];

        System.out.print("Original array: ");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rnd.nextInt(2);
        }
        System.out.print(Arrays.toString(array) + "\n");

        System.out.print("Modified array: ");
        for (int i = 0; i < arrayLength; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        System.out.print(Arrays.toString(array) + "\n");

    }

//2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

    private static void task2() {

        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        System.out.print(Arrays.toString(array) + "\n");

    }

//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    private static void task3() {

        int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) array[i] *= 2;

        System.out.print(Arrays.toString(array) + "\n");

    }

//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
// Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

    private static void task4(int arrayLength) {

        int[][] array = new int[arrayLength][arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                if (i == j || i + j == arrayLength - 1) array[i][j] = 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

//5. Написать метод, принимающий на вход два аргумента: len и initialValue,
// и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;

    private static int[] task5(int arrayLength, int initialValue) {
        int[] result = new int[arrayLength];
        Arrays.fill(result, initialValue);
        return result;
    }

//6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

    private static void task6(int arrayLength) {

        int[] array = new int[arrayLength];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arrayLength; i++) {
            array[i] = rnd.nextInt(40);
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);

    }

//7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
// если в массиве есть место, в котором сумма левой и правой части массива равны.
//**Примеры:
//    checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
//    checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
//
//    граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.

    private static boolean checkBalance(int[] array) {

        for (int i = 0; i < array.length; i++) {

            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j <= i; j++) {
                leftSum += array[j];
            }

            for (int j = array.length - 1; j > i; j--) {
                rightSum += array[j];
            }

            if (leftSum == rightSum) return true;

        }

        return false;

    }


//8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.
// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
// При каком n в какую сторону сдвиг можете выбирать сами.

    private static int[] moveArrayElementsNTimes(int[] array, int n) {

        int buffer;

        for (int i = 0; i < Math.abs(n) % array.length; i++) {

            if (n > 0) {

                buffer = array[array.length - 1];

                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }

                array[0] = buffer;

            }

            if (n < 0) {

                buffer = array[0];

                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }

                array[array.length - 1] = buffer;

            }

        }

        return array;

    }


}
