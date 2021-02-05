package main.Menu.Items;

import main.Menu.MenuItems;

public class Help implements MenuItems {
    public static String NAME = "help";
    @Override
    public void execute() {
        System.out.println("Commands: ");
        System.out.println("\""+Exit.NAME+"\" - terminates programs");
        System.out.println("\""+Equip.NAME+"\" - equip a knight and calculate the cost");
        System.out.println("\""+Print.NAME+"\" - print existing ammunition");
        System.out.println("\""+Delete.NAME+"\" - delete existing ammunition");
        System.out.println("\""+Add.NAME+"\" - add ammunition");
        System.out.println("\""+Knight.NAME+"\" - edit knight");
        System.out.println("\""+Border.NAME+"\" - print ammunition price from border");
    }
}
