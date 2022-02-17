package lesson6HomeWork;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.

public abstract class Animal {

    private static Integer count = 0;

    protected String title;
    protected String nickName;
    protected Integer swimDistance;
    protected Integer runDistance;

    protected Animal(String title, String nickName, Integer runDistance, Integer swimDistance) {
        this.title = title;
        this.nickName = nickName;
        this.swimDistance = swimDistance;
        this.runDistance = runDistance;
        count++;
    }

    protected void run(Integer distance) {
        if (distance > this.runDistance) {
            System.out.printf("%s не может пробежать больше %d метров!\n", this.title, this.runDistance);
        } else {
            System.out.printf("%s %s пробежал %d м.\n", this.title, this.nickName, distance);
        }
    }

    protected void swim(Integer distance) {
        if (this.swimDistance == 0) {
            System.out.printf("%s плавать не любит или не умеет!\n", this.title);
        } else if (distance > this.swimDistance) {
            System.out.printf("%s не может проплыть больше %d метров!\n", this.title, this.swimDistance);
        } else {
            System.out.printf("%s %s проплыл %d м.\n", this.title, this.nickName, distance);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nickName='" + nickName + '\'' +
                '}';
    }

    public static Integer getCount() {
        return count;
    }

}
