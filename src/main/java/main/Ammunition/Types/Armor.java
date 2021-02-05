package main.Ammunition.Types;

import main.Ammunition.Ammunition;

public class Armor extends Ammunition {
    private String typeOfArmor;
    private int defence;
    private String material;

    public Armor(int price, int weight, String typeOfArmor, int defence, String material) {
        super(price, weight);
        this.typeOfArmor = typeOfArmor;
        this.defence = defence;
        this.material = material;
    }

    @Override
    public String toString() {
        return "Armor (" +
                "type Of Armor='" + typeOfArmor + '\'' +
                ", defence=" + defence +
                ", material='" + material + '\'' +
                ", weight=" + this.getWeight() +
                ", price=" + this.getPrice() +
                ')';
    }

    public String getTypeOfArmor() {
        return typeOfArmor;
    }

    public void setTypeOfArmor(String typeOfArmor) {
        this.typeOfArmor = typeOfArmor;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
