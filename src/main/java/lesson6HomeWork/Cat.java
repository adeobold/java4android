package lesson6HomeWork;

public class Cat extends Animal {

    public static Integer count = 0;

    private Boolean isGoodHunter;

    public Cat() {
        this("Лохматый", false);
    }

    public Cat(String nickName, Boolean isGoodHunter) {
        super("Кот", nickName, 200, 0);
        this.isGoodHunter = isGoodHunter;
        this.count++;
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

}
