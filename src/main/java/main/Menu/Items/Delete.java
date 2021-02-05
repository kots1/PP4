package main.Menu.Items;

import main.Ammunition.AmmunitionCollection;
import main.Menu.MenuItems;

public class Delete implements MenuItems {
    public static String NAME ="delete";
    @Override
    public void execute() {
        AmmunitionCollection collections = AmmunitionCollection.getCollection();
        collections.deleteItem();
    }
}
