package main.Knight;

import main.Ammunition.Ammunition;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.ArrayList;
import java.util.Scanner;

public class Knight {
    private ArrayList<Ammunition> ammunition;
    private String name;
    private int price;
    Logger logger = Logger.getLogger(Knight.class);
    static {
        DOMConfigurator.configure("log4j.xml");
    }


    public Knight(ArrayList<Ammunition> ammunition, String name){
        this.ammunition = ammunition;
        this.name = name;
    }
    public void printKnight(){
        System.out.println("Name : "+name);
        printAmmunition();
        System.out.println("Total price : "+getPrice());
    }
    public void addAmmunition(Ammunition ammunition){
        this.ammunition.add(ammunition);
    }
    private void calculatePrice() {
        price = 0;
        for(Ammunition obj:ammunition){
            price+=obj.getPrice();
        }
    }

    public int getPrice() {
        calculatePrice();
        return price;
    }

    public void deleteItem(){
        int deleteNum = getDeleteNum();
        if(deleteNum != 0){
            ammunition.remove(deleteNum-1);
        }
    }
    private int getDeleteNum() {
        printAmmunition();
        System.out.println("Choose ammunition for delete( 0 - for exit)");
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true){
            num = scanner.nextInt();
            if (num>=0&&num<=ammunition.size()){
                return num;
            }else {
                logger.warn("out of ammunition size");
                System.out.println("Incorrect value");
            }
        }
    }

    private void printAmmunition() {
        if(ammunition.isEmpty()){
            System.out.println("Array is empty");
        }
        int i=1;
        System.out.println("Ammunition on the knight:");
        for (Ammunition obj:ammunition){
            System.out.println(i+")"+obj);
            i++;
        }
    }
}
