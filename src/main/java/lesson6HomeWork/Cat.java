package lesson6HomeWork;

public class Cat extends Animal {

    private static Integer count = 0;

    private final Boolean isGoodHunter;

    public Cat() {
        this("Лохматый", false);
    }

    public Cat(String nickName, Boolean isGoodHunter) {
        super("Кот", nickName, 200, 0);
        this.isGoodHunter = isGoodHunter;
        count++;
    }

    public void purr() {
        System.out.printf("%s мурлычет!\n", this.nickName);
    }

    @Override
    public String toString() {
        if (isGoodHunter) {
            return String.format("%s хороший охотник", this.nickName);
        } else {
            return String.format("%s охотник так себе", this.nickName);
        }
    }

    public void printInfo() {
        System.out.println(this);
    }

    public static Integer getCount() {
        return count;
    }

}
