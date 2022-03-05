package lesson10HomeWork;

public class Apple extends Fruit{

    public Apple() {
        super(1.0);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "WEIGHT=" + WEIGHT +
                '}';
    }

}
