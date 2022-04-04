package lesson3HomeWork;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;
import java.util.stream.Stream;

class HomeWorkAppTest {

    protected static final Logger logger7 = Logger.getLogger("testHomeWork3Task7");
    protected static final Logger logger8 = Logger.getLogger("testHomeWork3Task8");

    private static HomeWorkApp homeWorkApp;

    @BeforeAll
    static void beforeAll() throws IOException {
        System.out.println("Начало всех тестов");
        homeWorkApp = new HomeWorkApp();

        logger7.setLevel(Level.ALL);
        logger8.setLevel(Level.ALL);

        Handler handlerAll = new FileHandler("src/main/resources/logs/logAll.log");
        Handler handler7 = new FileHandler("src/main/resources/logs/log7.log");
        Handler handler8 = new FileHandler("src/main/resources/logs/log8.log");

        handlerAll.setLevel(Level.ALL);
        handler7.setLevel(Level.INFO);
        handler8.setLevel(Level.INFO);

        handlerAll.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("%s\t%s\t%s%n", record.getLevel(), new Date(record.getMillis()), record.getMessage());
            }
        });

        handler7.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("%s\t%s\t%s%n", record.getLevel(), new Date(record.getMillis()), record.getMessage());
            }
        });

        handler8.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return String.format("%s\t%s\t%s%n", record.getLevel(), new Date(record.getMillis()), record.getMessage());
            }
        });

        logger7.addHandler(handlerAll);
        logger7.addHandler(handler7);
        logger8.addHandler(handlerAll);
        logger8.addHandler(handler8);

    }

    @DisplayName("Тест задания 7 урока 3")
    @ParameterizedTest
    @MethodSource("data7")
    void testTask7(int[] a) {
        logger7.log(Level.INFO, "Тест для задания 7: " + Arrays.toString(a));
        Assertions.assertTrue(homeWorkApp.checkBalance(a));
        logger7.log(Level.INFO, "Успешно!");
    }

    static Stream<Arguments> data7() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 1, 2, 2}),
                Arguments.arguments(new int[]{2, 2, 1, 2, 2, 1})
        );
    }

    @DisplayName("Тест задания 8 урока 3")
    @ParameterizedTest
    @MethodSource("data8")
    void testTask8(int[] expectedArray, int[] a, int times) {
        logger8.log(Level.INFO, "Тест для задания 8: " + Arrays.toString(expectedArray) + " и " + Arrays.toString(a) + " сдвиг " + times);
        Assertions.assertArrayEquals(expectedArray, homeWorkApp.moveArrayElementsNTimes(a, times));
        logger8.log(Level.INFO, "Успешно!");
    }

    static Stream<Arguments> data8() {
        return Stream.of(
                Arguments.arguments(new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1),
                Arguments.arguments(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9),
                Arguments.arguments(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, -1)
        );
    }

}