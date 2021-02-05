package main.Menu.Items;

import main.Ammunition.AmmunitionCollection;
import main.Menu.MenuItems;

public class Print implements MenuItems {
    public static String NAME= "print";
    @Override
    public void execute() {
        AmmunitionCollection collection = AmmunitionCollection.getCollection();
        collection.printAmmunition();
    }
}
