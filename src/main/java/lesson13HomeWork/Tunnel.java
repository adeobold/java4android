package lesson13HomeWork;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private final Semaphore smp;

    public Tunnel(int throughput) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        smp = new Semaphore(throughput);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " +
                        description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " +
                        description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
