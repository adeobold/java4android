package lesson5HomeWork;

public class Main {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Петр Петрович", "директор", "ivanov@domen.ru", "89991231211", 100000, 59);
        employees[1] = new Employee("Петров Иван Иванович", "зам. директора", "petrov@domen.ru", "89991231212", 75000, 45);
        employees[2] = new Employee("Пушкина Зинаида Петровна", "бухгалтер", "pushkina@domen.ru", "89991231213", 50000, 67);
        employees[3] = new Employee("Карамзин Олег Алексеевич", "водитель", "karamzin@domen.ru", "89991231214", 25000, 33);
        employees[4] = new Employee("Толстой Михаил Андреевич", "охранник", "tolstoy@domen.ru", "89991231215", 20000, 25);

        employees[0].increaseSalary(50000);

        for (Employee e : employees) {
            if (e.getAge() > 40) {
                System.out.println(e);
            }
        }

        employees[0].increaseSalary(20000);

        System.out.println(employees[0]);

        System.out.println("Общее количество сотрудников: " + Employee.employeeCount);

    }

}
