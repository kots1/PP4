package main.Ammunition;

import main.Ammunition.Types.Armor;
import main.Ammunition.Types.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.*;

public class AmmunitionCollectionTest{
    AmmunitionCollection collection;
    ArrayList<Ammunition>arrayList;
    @Before
    public void setUp() throws Exception {
        arrayList=new ArrayList<>();
        arrayList.add(new Armor(250, 42, "armor1", 200, "metal"));
        arrayList.add(new Armor(150, 34, "armor2", 200, "metal"));
        arrayList.add(new Armor(300, 27, "armor3", 200, "metal"));
        arrayList.add(new Armor(540, 51, "armor4", 200, "metal"));
        arrayList.add(new Armor(380, 97, "armor5", 200, "metal"));
        arrayList.add(new Weapon(354, 30, "Weapon1", 200, "metal"));
        arrayList.add(new Weapon(457, 48, "Weapon2", 200, "metal"));
        arrayList.add(new Weapon(320, 52, "Weapon3", 200, "metal"));
        arrayList.add(new Weapon(257, 35, "Weapon4", 200, "metal"));
        collection =new  AmmunitionCollection(arrayList);

    }

    @Test
    public void getAmmunitionFromBorder() {
        ArrayList<Ammunition>expectedList =new ArrayList<>();
        int min= 290;
        int max=360;
        expectedList.add(arrayList.get(0));
        expectedList.add(arrayList.get(1));
        expectedList.add(arrayList.get(7));
        ArrayList<Ammunition> getList =collection.getAmmunitionFromBorder(min,max);
        Assert.assertEquals(expectedList,getList);
    }
    @Test
    public void sortedList() {
        ArrayList<Ammunition>expectedList =new ArrayList<>(collection.getAmmunition());
        Collections.sort(expectedList, new Comparator<Ammunition>() {
            @Override
            public int compare(Ammunition o1, Ammunition o2) {
               return Integer.compare(o1.getWeight(),o2.getWeight());
            }
        });

        Assert.assertEquals(collection.getAmmunition(),expectedList);
    }
}