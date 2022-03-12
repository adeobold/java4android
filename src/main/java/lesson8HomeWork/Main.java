package lesson8HomeWork;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {

        Human human = new Human("Элиуд Кипчоге", 1, 42);
        Cat cat = new Cat("Барсик", 2, 10);
        Robot robot = new Robot("R2D2", 0, 100);

        Treadmill treadmill1 = new Treadmill(42);
        Treadmill treadmill2 = new Treadmill(10);

        Wall wall1 = new Wall(1);
        Wall wall2 = new Wall(2);

        Participant[] participants = {human, cat, robot};
        Obstacle[] obstacles = {treadmill1, wall1, treadmill2, wall2};

        System.out.println("Репортаж с соревнований начинается!");

        for (Participant participant : participants) {

            System.out.printf("\tНа полосу препятствий выходит %s!\n", participant.getName());

            for (Obstacle obstacle : obstacles) {

                System.out.printf("\t\tСнаряд %s - ", obstacle.obstacleInfo());

                if (!obstacle.obstacleTaken(participant)) {
                    System.out.printf(ANSI_RED + "участник %s не справился и выбывает из соревнований!\n" + ANSI_RESET, participant.getName());
                    break;
                }

                System.out.println(ANSI_GREEN + "успешно пройден!" + ANSI_RESET);

            }

        }

        System.out.println("Репортаж окончен!");

    }

}
