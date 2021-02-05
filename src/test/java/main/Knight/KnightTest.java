package main.Knight;

import main.Ammunition.Ammunition;
import main.Ammunition.Types.Armor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class KnightTest {
    Knight knight;
    @Before
    public void beforeInitialization(){
        ArrayList<Ammunition> arrayList = new ArrayList<>();
        arrayList.add(new Armor(250, 25, "armor1", 200, "metal"));
        arrayList.add(new Armor(150, 25, "armor1", 200, "metal"));
        arrayList.add(new Armor(300, 25, "armor1", 200, "metal"));
        arrayList.add(new Armor(540, 25, "armor1", 200, "metal"));
        arrayList.add(new Armor(380, 25, "armor1", 200, "metal"));
        knight = new Knight(arrayList,"knight");
    }
    @Test
    public void TestCountPrice() {
        int exPriceKnight = 1620;
        Assert.assertEquals(exPriceKnight,knight.getPrice());
    }
}