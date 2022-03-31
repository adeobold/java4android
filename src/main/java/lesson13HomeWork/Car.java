package lesson13HomeWork;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private int lastStageDone;
    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

        lastStageDone = 0;

    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void race() {
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            lastStageDone++;
        }
    }

    public int getLastStageDone() {
        return lastStageDone;
    }

}
