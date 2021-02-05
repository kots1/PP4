package main.Menu.Items;

import main.Ammunition.Ammunition;
import main.Ammunition.AmmunitionCollection;
import main.Menu.MenuItems;

import java.util.ArrayList;
import java.util.Scanner;

public class Border implements MenuItems {
    public static String NAME="border";
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        AmmunitionCollection collection = AmmunitionCollection.getCollection();
        System.out.println("Minimum value");
        int min = scanner.nextInt();
        System.out.println("Maximum value");
        int max = scanner.nextInt();
        ArrayList<Ammunition> arrayList = collection.getAmmunitionFromBorder(min,max);
        printArray(arrayList);
    }

    private void printArray(ArrayList<Ammunition> arrayList) {
        if(arrayList.isEmpty()){
            System.out.println("Array is empty");
            return;
        }
        System.out.println("Array");
        for (Ammunition object: arrayList){
            System.out.println(object);
        }
    }
}
