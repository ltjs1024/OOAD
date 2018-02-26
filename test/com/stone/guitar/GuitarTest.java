package com.stone.guitar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GuitarTest {

    private static Inventory guitars;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        guitars = new Inventory();
        initializeInventory(guitars);
    }

    private static void initializeInventory(Inventory inventory) {

        inventory.addGuitar("V95693", 1499.95, "Fender",
                "Stratocastor", "electric", "Alder", "Alder");
        inventory.addGuitar("V9512", 1549.95, "Fender",
                "Stratocastor", "electric", "Alder", "Alder");
    }

    @AfterClass
    public static void setupAfterClass() throws Exception {

    }

    /**
     * @throws Exception
     */
    @Test
    public void testSearch() throws Exception {
        Guitar searchGuitar = new Guitar("", 0, "Fender",
                "Stratocastor", "electric", "Alder", "Alder");
        Guitar search = guitars.search(searchGuitar);
        String expected = "Guitar{serialNumber='V95693', price=1499.95, builder='Fender', model='Stratocastor', type='electric', backWood='Alder', topWood='Alder'}";
        Assert.assertEquals(expected, search.toString());
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSearchNotExist() throws Exception {
        Guitar searchGuitar = new Guitar("", 0, "Any",
                "Stratocastor", "electric", "Alder", "Alder");
        Guitar search = guitars.search(searchGuitar);
        String expected = null;
        Assert.assertEquals(expected, search == null ? null : search.toString());
    }
}
