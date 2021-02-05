package main;

import main.Ammunition.Ammunition;
import main.Ammunition.AmmunitionCollection;
import main.Knight.KnightCollection;
import main.Menu.MainMenu;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main extends Object{
    static Logger logger = Logger.getLogger(Main.class);
     static {
        DOMConfigurator.configure("log4j.xml");
    }
    public static void main(String[] args) {
        AmmunitionCollection ammunitionCollection = getFromFile();
        KnightCollection knightCollection =new KnightCollection();
        MainMenu menu = new MainMenu();
        menu.startMenu();
    }

    private static AmmunitionCollection getFromFile() {
        ArrayList<Ammunition> saveArray = new ArrayList<>();
        try {
            logger.info("read array of ammunition from file");
            FileInputStream fs = new FileInputStream("Ammunition.ser");
            if (fs.available() <= 0) {
                return new AmmunitionCollection(saveArray);
            }
            ObjectInputStream os = new ObjectInputStream(fs);
            Ammunition ammunition;
            while ((fs.available()) > 0) {
                ammunition = (Ammunition) os.readObject();
                saveArray.add(ammunition);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error("File for reading not found");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error reading from file");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("Class not found");
        }
            return new AmmunitionCollection(saveArray);
    }
}
