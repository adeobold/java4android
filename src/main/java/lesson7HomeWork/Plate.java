package lesson7HomeWork;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {

        if (food >= n) {
            food -= n;
            return true;
        }

        System.out.println("Еды в тарелке недостаточно!");
        return false;

    }

    public void increaseFood(int n) {
        food += n;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}
