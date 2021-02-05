package main.Menu.Items;

import main.Knight.KnightCollection;
import main.Menu.MenuItems;

public class Equip implements MenuItems {
    public static String NAME = "equip";
    @Override
    public void execute() {
        KnightCollection collection = KnightCollection.getCollection();
        collection.addKnight();
    }
}
