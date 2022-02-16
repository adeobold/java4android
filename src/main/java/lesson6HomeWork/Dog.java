package lesson6HomeWork;

public class Dog extends Animal {

    private static Integer count = 0;

    private String breed;

    public Dog() {
        this("Дворняга", "беспородная");
    }

    public Dog(String nickName, String breed) {
        super("Собака", nickName, 500, 10);
        this.breed = breed;
        this.count++;
    }

    @Override
    public String toString() {
        return  String.format("Пес %s породы %s", this.nickName, this.breed);
    }

    public void printInfo() {
        System.out.println(this);
    }

    public void wagTail() {
        System.out.printf("%s виляет хвостом и рад вас видеть\n", this.nickName);
    }

    public static Integer getCount() {
        return count;
    }

}
