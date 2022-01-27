package lesson2HomeWork;

public class HomeWorkApp {

    public static void main(String[] args) {

        System.out.println(isSumInRange(5, 16));

        printPositive(2);

        System.out.println(isNegative(2));

        printStringNCount("Test string!!!", 3);

        System.out.println(isYearLeap(2019));
    }

    private static boolean isSumInRange(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    private static void printPositive(int a) {
        if (a >= 0) System.out.printf("Число %d положительное\n", a);
        else System.out.printf("Число %d отрицательное\n", a);
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    private static void printStringNCount(String str, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(str);
            }
        } else {
            System.out.println("Внимание! Аргумент n должен быть больше 0!");
        }
    }

    private static boolean isYearLeap(int year) {
        boolean result = false;
        if (year % 400 == 0) {
            result = true;
        }
        else if(year % 4 == 0 && year % 100 != 0) {
            result = true;
        }
        return result;
    }

}
