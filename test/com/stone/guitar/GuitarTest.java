package com.stone.guitar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class GuitarTest {

    private static Inventory guitars;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        guitars = new Inventory();
        initializeInventory(guitars);
    }

    private static void initializeInventory(Inventory inventory) {
        inventory.addGuitar("V3721", 1599.95, new GurtarSpec(Builder.GIBSON,
                "Gibson", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.BRAZILIAN_ROSEWOOD));
        inventory.addGuitar("V95693", 1499.95, new GurtarSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        inventory.addGuitar("V9512", 1549.95, new GurtarSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
    }

    @AfterClass
    public static void setupAfterClass() throws Exception {

    }

    /**
     * 库存中匹配到唯一的吉他
     *
     * @throws Exception
     */
    @Test
    public void testSearchOnly() throws Exception {
        Guitar searchGuitar = new Guitar("", 0, new GurtarSpec(Builder.GIBSON,
                "Gibson", Type.ACOUSTIC, Wood.BRAZILIAN_ROSEWOOD, Wood.BRAZILIAN_ROSEWOOD));
        List<Guitar> searchGuitars = guitars.search(searchGuitar);
        String expected = "[Guitar{serialNumber='V3721', price=1599.95, builder='Gibson', model='Gibson', type='Acoustic', backWood='Brazilian Rosewood', topWood='Brazilian Rosewood'}]";
        Assert.assertEquals(expected, searchGuitars.toString());
    }

    /**
     * 库存中匹配到多个吉他
     *
     * @throws Exception
     */
    @Test
    public void testSearchMultis() throws Exception {
        Guitar searchGuitar = new Guitar("", 0, new GurtarSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        List<Guitar> result = guitars.search(searchGuitar);
        String expected = "[Guitar{serialNumber='V95693', price=1499.95, builder='Fender', model='Stratocastor', type='Electric', backWood='Alder', topWood='Alder'}," +
                " Guitar{serialNumber='V9512', price=1549.95, builder='Fender', model='Stratocastor', type='Electric', backWood='Alder', topWood='Alder'}]";
        Assert.assertEquals(expected, result.toString());
    }

    /**
     * 库存中没有匹配到
     *
     * @throws Exception
     */
    @Test
    public void testSearchNotExist() throws Exception {
        Guitar searchGuitar = new Guitar("", 0, new GurtarSpec(Builder.ANY,
                "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER));
        List<Guitar> search = guitars.search(searchGuitar);
        String expected = "[]";
        Assert.assertEquals(expected, search.toString());
    }
}
