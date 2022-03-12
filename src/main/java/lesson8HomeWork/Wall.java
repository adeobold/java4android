package lesson8HomeWork;

public class Wall implements Obstacle{

    private Integer height;

    public Wall(Integer height) {
        this.height = height;
    }

    @Override
    public boolean obstacleTaken(Participant participant) {
        return participant.jump(height);
    }

    @Override
    public String obstacleInfo() {
        return "Стена высотой " + this.height + " м";
    }
}
