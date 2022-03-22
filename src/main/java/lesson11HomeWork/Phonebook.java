package lesson11HomeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {

    private Map<String, List<String>> phones;

    public Phonebook() {
        this.phones = new HashMap<>();
    }

    public void add(String name, String phoneNumber){
        phones.putIfAbsent(name, new ArrayList<>());
        phones.get(name).add(phoneNumber);
    }

    public List<String> get(String name){
        return phones.get(name);
    }


}
