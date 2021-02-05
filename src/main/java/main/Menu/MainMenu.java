package main.Menu;

import main.Menu.Items.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MainMenu {
    Map<String,MenuItems> Items ;
    Logger logger = Logger.getLogger(MainMenu.class);
     {
        DOMConfigurator.configure("log4j.xml");
    }
    public MainMenu(){

        Items = new HashMap<>();
        Items.put(Exit.NAME,new Exit());
        Items.put(Help.NAME,new Help());
        Items.put(Equip.NAME,new Equip());
        Items.put(Print.NAME,new Print());
        Items.put(Delete.NAME,new Delete());
        Items.put(Knight.NAME,new Knight());
        Items.put(Add.NAME,new Add());
        Items.put(Border.NAME,new Border());
        logger.info("Menu items create");
    }
    public void execute(String command){
        if(Items.containsKey(command)){
            logger.info("Choose "+command +" in menu");
            Items.get(command).execute();
        }else {
            System.out.println("Incorrect message ");
        }
    }
    public void startMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose  command (\"help\" for information) :");
            execute(scanner.nextLine());
        }
    }

}
