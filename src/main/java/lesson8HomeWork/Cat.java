package lesson8HomeWork;

public class Cat implements Participant{

    private String name;
    private Integer jumpLimit;
    private Integer runLimit;

    public Cat(String name, Integer jumpLimit, Integer runLimit) {
        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean jump(Integer height) {
        return height <= jumpLimit;
    }

    @Override
    public boolean run(Integer distance) {
        return distance <= runLimit;
    }

}
