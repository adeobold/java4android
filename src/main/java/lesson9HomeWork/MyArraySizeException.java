package lesson9HomeWork;

import java.io.IOException;

public class MyArraySizeException extends IOException {

    public MyArraySizeException(){
        super("Размер массива должен быть 4x4!");
    }

}
