package main.Ammunition;

import main.Ammunition.Types.Armor;
import main.Ammunition.Types.Weapon;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class AmmunitionCollection {
    private ArrayList<Ammunition> ammunition;
    private static AmmunitionCollection collection;
    Logger logger = Logger.getLogger(AmmunitionCollection.class);

    static {
        DOMConfigurator.configure("log4j.xml");
    }

    public ArrayList<Ammunition> getAmmunition() {
        return ammunition;
    }

    public AmmunitionCollection(ArrayList<Ammunition> ammunition) {

        this.ammunition = ammunition;
        collection = this;
        Collections.sort(this.ammunition);
    }

    public static AmmunitionCollection getCollection() {
        return collection;
    }

    public void addAmmunition(Ammunition ammunition) {
        this.ammunition.add(ammunition);
        Collections.sort(this.ammunition);
        logger.info("add new ammunition in array");
    }

    public Ammunition getAmmunition(int index) {
        return ammunition.get(index);
    }

    public void printAmmunition() {
        logger.info("print array of ammunition");

        if (ammunition.isEmpty()) {
            System.out.println("Array is empty");
            return;
        }
        System.out.println("Array of ammunition:");
        int num = 1;
        for (Ammunition element : ammunition) {
            System.out.println(num + ")" + element);
            num++;
        }
    }

    public ArrayList<Ammunition> getAmmunitionFromBorder(int min, int max) {
        ArrayList<Ammunition> array = new ArrayList<>();
        logger.info("get array of ammunition from border :[" + min + "," + max + "]");
        for (Ammunition object : ammunition) {
            int price = object.getPrice();
            if (price >= min && price <= max) {
                array.add(object);
            }
        }
        return array;
    }

    public void deleteItem() {
        logger.info("delete ammunition");
        int deleteNum = getDeleteNum();
        if (deleteNum != 0) {
            ammunition.remove(deleteNum - 1);
        }
        Collections.sort(this.ammunition);
    }

    private int getDeleteNum() {
        printAmmunition();
        System.out.println("Choose ammunition for delete( 0 - for exit)");
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            num = scanner.nextInt();
            if (num >= 0 && num <= ammunition.size()) {
                return num;
            } else {
                logger.warn("Out of ammunition size");
                System.out.println("Incorrect value");
            }
        }
    }

    public void saveInFile() {
        try {
            logger.info("save array in file");
            FileOutputStream fs = new FileOutputStream("Ammunition.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            for (Ammunition ammunition : ammunition) {
                os.writeObject(ammunition);
            }
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("file for saving not found");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error writing in file");
        }
    }

    public Ammunition createAmmunition() {
        int type = chooseType();
        logger.info("create ammunition");
        if (type == 1) {
            return createArmor();
        } else {
            return createWeapon();
        }
    }

    private Ammunition createWeapon() {
        logger.info("create weapon");
        System.out.println("Price :");
        int price = getData();
        System.out.println("Weight :");
        int weight = getData();
        System.out.println("Type of weapon:");
        String typeOfWeapon = getString();
        System.out.println("Attack :");
        int attack = getData();
        System.out.println("Material :");
        String material = getString();
        return new Weapon(price, weight, typeOfWeapon, attack, material);
    }

    private String getString() {
        return new Scanner(System.in).nextLine();
    }

    private int getData() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int data = scan.nextInt();
            if (data > 0) {
                return data;
            } else {
                logger.warn("Incorrect value for data:negative");
                System.out.println("Incorrect value");
            }
        }
    }

    private Ammunition createArmor() {
        logger.info("create armor");
        System.out.println("Price :");
        int price = getData();
        System.out.println("Weight :");
        int weight = getData();
        System.out.println("Type of armor:");
        String typeOfArmor = getString();
        System.out.println("Defence :");
        int defence = getData();
        System.out.println("Material :");
        String material = getString();
        return new Armor(price, weight, typeOfArmor, defence, material);

    }

    private int chooseType() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose type of ammunition:");
        System.out.println("1)armor");
        System.out.println("2)weapon");
        while (true) {
            int type = scan.nextInt();
            if (type == 1 || type == 2) {
                return type;
            } else {
                logger.warn("choose not incorrect type of ammunition");
                System.out.println("Incorrect value");
            }
        }
    }
}
