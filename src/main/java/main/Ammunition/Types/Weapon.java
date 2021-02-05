package main.Ammunition.Types;

import main.Ammunition.Ammunition;

public class Weapon extends Ammunition {
    private String typeOfWeapon;
    private int attack;
    private String material;

    public Weapon(int price, int weight, String typeOfWeapon, int attack, String material) {
        super(price, weight);
        this.typeOfWeapon = typeOfWeapon;
        this.attack = attack;
        this.material = material;
    }
    @Override
    public String toString() {
        return "Weapon (" +
                "type Of weapon='" + typeOfWeapon + '\'' +
                ", attack=" + attack +
                ", material='" + material + '\'' +
                ", weight=" + this.getWeight() +
                ", price=" + this.getPrice() +
                ')';
    }
    public String getTypeOfWeapon() {
        return typeOfWeapon;
    }

    public void setTypeOfWeapon(String typeOfWeapon) {
        this.typeOfWeapon = typeOfWeapon;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
