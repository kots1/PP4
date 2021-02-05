package main.Menu.Items;

import main.Ammunition.Ammunition;
import main.Ammunition.AmmunitionCollection;
import main.Menu.MenuItems;

public class Add implements MenuItems {
    public static String NAME = "add";
    @Override
    public void execute() {
        AmmunitionCollection collections = AmmunitionCollection.getCollection();
        Ammunition ammunition = collections.createAmmunition();
        collections.addAmmunition(ammunition);
    }
}
