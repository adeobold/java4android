package lesson10HomeWork;

import java.util.ArrayList;

public class FruitBox<T extends Fruit> {

    private final ArrayList<T> storage;

    public FruitBox() {
        storage = new ArrayList<>();
    }

    public Double getWeight(){
        Double weight = 0.0;
        for (T t : storage) {
            weight += t.WEIGHT;
        }
        return weight;
    }

    public void addFruit(T fruit){
        storage.add(fruit);
    }

    @Override
    public String toString() {
        return "FruitBox{" +
                "storage=" + storage +
                '}';
    }

    public Boolean compare(FruitBox<?> anotherFruitBox){
        return Math.abs(this.getWeight() - anotherFruitBox.getWeight()) < 0.0001;
    }

    public void pourToAnotherBox(FruitBox<T> anotherFruitBox){

        for (T fruit : storage) {
            anotherFruitBox.addFruit(fruit);
        }

        storage.clear();

    }

}
