package main.Ammunition;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Ammunition implements Serializable, Comparable<Ammunition> {
    private int price;
    private int weight;

    public Ammunition(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public int compareTo(Ammunition o) {
        return Integer.compare(weight,o.weight);
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

}
