package main.Menu.Items;

import main.Ammunition.AmmunitionCollection;
import main.Menu.MenuItems;

public class Exit implements MenuItems {
    public static String NAME = "exit";


    @Override
    public void execute() {
        AmmunitionCollection collection = AmmunitionCollection.getCollection();
        collection.saveInFile();
        System.out.println("Exit...");
        System.exit(0);
    }
}
