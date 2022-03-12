package lesson10HomeWork;

public class Main {

    public static void main(String[] args) {

        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        System.out.println(appleBox);
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());

        FruitBox<Orange> orangeBox = new FruitBox<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());



        System.out.println(orangeBox);
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        if (appleBox.compare(orangeBox)){
            System.out.println("Вес коробок одинаковый");
        } else {
            System.out.println("Вес коробок разный");
        }

        FruitBox<Orange> orangeBox1 = new FruitBox<>();

        System.out.println(orangeBox1);

        orangeBox.pourToAnotherBox(orangeBox1);

        System.out.println(orangeBox1);
        System.out.println(orangeBox);

    }




}
