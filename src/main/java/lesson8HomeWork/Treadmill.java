package lesson8HomeWork;

public class Treadmill implements Obstacle {

    private Integer distance;

    public Treadmill(Integer distance) {
        this.distance = distance;
    }

    @Override
    public boolean obstacleTaken(Participant participant) {
        return participant.run(distance);
    }

    @Override
    public String obstacleInfo() {
        return "Беговая дорожка на " + this.distance + " км";
    }
}
