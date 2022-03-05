package lesson10HomeWork;

import java.util.Arrays;

public class GenericSwap<T> {

    public static void main(String[] args) {

        GenericSwap<Integer> genericSwap = new GenericSwap<>();

        Integer[] integers = new Integer[]{1,2,3,4,5};
        System.out.println(Arrays.toString(integers));
        genericSwap.swapElements(integers, 2,4);
        System.out.println(Arrays.toString(integers));


        GenericSwap<String> genericSwap1 = new GenericSwap<>();

        String[] strings = new String[]{"a","b","c","d","e"};
        System.out.println(Arrays.toString(strings));
        genericSwap1.swapElements(strings, 2,4);
        System.out.println(Arrays.toString(strings));

    }

    public void swapElements(T[] array, int firstIndex, int secondIndex){

        T buffer = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = buffer;

    }

}
