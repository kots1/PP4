package main.Menu.Items;

import main.Knight.KnightCollection;
import main.Menu.MenuItems;

import java.util.Scanner;

public class Knight implements MenuItems {
    public static String NAME = "knight";
    @Override
    public void execute() {
        KnightCollection collection =KnightCollection.getCollection();
        collection.printKnight();
        menu( collection);
    }
    public void menu(KnightCollection collection){
        Scanner scanner =new Scanner(System.in);

        while (true){
            System.out.println("\nChoose command");
            System.out.println("1)Add ammunition");
            System.out.println("2)Delete ammunition");
            System.out.println("3)Delete knight");
            System.out.println("4)Exit");
            int choice =scanner.nextInt();
            switch (choice){
                case 1:
                    collection.addKnightAmmunition();
                   break;
                case 2:
                    collection.deleteAmmunitionFromKnight();
                    break;
                case 3:
                    collection.deleteItem();
                    break;
                default:
                    return;
            }
        }
    }
}
