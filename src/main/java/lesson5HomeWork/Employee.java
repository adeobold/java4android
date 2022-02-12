package lesson5HomeWork;

public class Employee {

    public static int employeeCount;

    private String name;
    private String position;
    private String email;
    private String phone;
    private Integer salary;
    private Integer age;

    public Employee(String name, String position, String email, String phone, Integer salary, Integer age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

        employeeCount++;

    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s, должность: %s, email: %s, тел.: %s, зп: %d, возраст: %d ", name, position, email, phone, salary, age);
    }

    public void increaseSalary(int increaseValue){
        if (increaseValue < 0) {
            System.out.println("Нельзя увеличить зарплату на отрицательное число!");
        } else if (increaseValue > Short.MAX_VALUE) {
            System.out.println("Слишком резкое увеличение зарплаты. Бухгалтер не оценит!");
        } else {
            this.salary += increaseValue;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
