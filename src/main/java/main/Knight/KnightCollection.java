package main.Knight;

import main.Ammunition.Ammunition;
import main.Ammunition.AmmunitionCollection;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;
import java.util.Scanner;

public class KnightCollection {
    private ArrayList<Knight> knights;
    private static KnightCollection collection;
    Logger logger = Logger.getLogger(KnightCollection.class);
     {
        DOMConfigurator.configure("log4j.xml");
    }


    public KnightCollection() {
        knights = new ArrayList<>();
        collection = this;
    }
    public void addKnight(){
        knights.add(createKnight());
    }

    private Knight createKnight() {
        System.out.println("Create knight");
        System.out.println("Choose ammunition (0 for skip)");
        ArrayList<Ammunition> arrayList =chooseKnightAmmunition();
        System.out.println("Set name");
        String name = getName();
        logger.info("create knight name :"+name);
        return new Knight(arrayList,name);
    }
    private String getName(){
        return new Scanner(System.in).nextLine();
    }

    private ArrayList<Ammunition> chooseKnightAmmunition(){
        ArrayList<Ammunition> arrayList=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        AmmunitionCollection collection =AmmunitionCollection.getCollection();
        while (true){
            collection.printAmmunition();
            int choice = scanner.nextInt();
            if(choice == 0){
                break;
            }
            arrayList.add(collection.getAmmunition(choice-1));
        }
        return arrayList;
    }

    public static KnightCollection getCollection(){
        return collection;
    }

    public void deleteItem(){
        int deleteNum = getDeleteNum();
         logger.info("delete knight num "+deleteNum);
        if(deleteNum != 0){
            knights.remove(deleteNum-1);
        }
    }

    public void printKnight() {
        if(knights.isEmpty()){
            System.out.println("Array is empty");
            return;
        }
        int i=1;
        System.out.println("Knights:");
        for (Knight obj:knights){
            System.out.println("------------------");
            System.out.println(i+")");
            obj.printKnight();
            i++;
            System.out.println("------------------");

        }
    }

    private int getDeleteNum() {
        printKnight();
        System.out.println("Choose knights for delete( 0 - for exit)");
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true){
            num = scanner.nextInt();
            if (num>=0&&num<=knights.size()){
                return num;
            }else {
                logger.warn("out of knights size");
                System.out.println("Incorrect value");
            }
        }
    }

    public void addKnightAmmunition() {
         logger.info("add ammunition to knight");
        Scanner scanner = new Scanner(System.in);
        printKnight();
        System.out.println("Choose knight for edit");
        int choiceKnight = scanner.nextInt();
        AmmunitionCollection ammunitionCollection = AmmunitionCollection.getCollection();
        ammunitionCollection.printAmmunition();
        System.out.println("Choose ammunition which you want to add");
        int choiceAmmunition =scanner.nextInt();
        Ammunition ammunition = ammunitionCollection.getAmmunition(choiceAmmunition-1);
        knights.get(choiceKnight-1).addAmmunition(ammunition);
    }

    public void deleteAmmunitionFromKnight() {
        logger.info("delete knight ammunition");
        Scanner scanner = new Scanner(System.in);
        printKnight();
        System.out.println("Choose knight for edit");
        int choiceKnight = scanner.nextInt();
        knights.get(choiceKnight-1).printKnight();
        System.out.println("Choose ammunition for edit");
        knights.get(choiceKnight-1).deleteItem();
    }
}
