package lesson9HomeWork;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(int i, int j) {
        super(String.format("В массиве на позиции [%s][%s] находится не число!", i, j));
    }

}
