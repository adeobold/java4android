package lesson11HomeWork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) {

        String[] words = {"aaa", "bbb", "ccc", "aaa", "bbb", "ccc", "aaa", "aaa", "ccc", "aaa", "bbb", "ddd"};

        System.out.println(uniqueWords(words));

        Phonebook phonebook = new Phonebook();

        phonebook.add("Иванов", "8-955-255-55-55");
        phonebook.add("Иванов", "8-955-255-55-56");
        phonebook.add("Петров", "8-966-266-66-66");
        phonebook.add("Петров", "8-966-266-66-67");
        phonebook.add("Сидоров", "8-977-277-77-77");

        System.out.println("Иванов: " + phonebook.get("Иванов"));
        System.out.println("Петров: " + phonebook.get("Петров"));
        System.out.println("Сидоров: " + phonebook.get("Сидоров"));

    }

    private static Map<String, Integer> uniqueWords(String[] words) {

        Map<String, Integer> uniqueWordsCount = new TreeMap<>();
        for (String s : words) {
            uniqueWordsCount.putIfAbsent(s, 0);
            uniqueWordsCount.replace(s, uniqueWordsCount.get(s) + 1);
        }
        return uniqueWordsCount;

    }

}
