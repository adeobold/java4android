package lesson7HomeWork;

public class Cat {

    private String name;
    private int appetite;
    private boolean isSatiety;

    public Cat() {
        this("Безымянный", 0);
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isSatiety = false;
    }

    public void eat(Plate p) {

        System.out.println("Кот " + this.name + " ecт!");
        isSatiety = p.decreaseFood(appetite);

    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isSatiety=" + isSatiety +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setSatiety(boolean satiety) {
        this.isSatiety = satiety;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getSatiety() {
        return isSatiety;
    }



}
