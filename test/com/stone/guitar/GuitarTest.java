package com.stone.guitar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class GuitarTest {

    private static Inventory inventory;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        inventory = new Inventory();
        initializeInventory(inventory);
    }

    private static void initializeInventory(Inventory inventory) {
        // 添加Guitar
        inventory.addInstrument("V3721", 1599.95, new GuitarSpec(Builder.GIBSON,
                "Gibson", Type.ACOUSTIC, 4, Wood.BRAZILIAN_ROSEWOOD, Wood.BRAZILIAN_ROSEWOOD));
        inventory.addInstrument("V95693", 1499.95, new GuitarSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER));
        inventory.addInstrument("V9512", 1549.95, new GuitarSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER));
        // 添加Mandolin
        inventory.addInstrument("M95693", 1349.95, new MandolinSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, Style.A));
        inventory.addInstrument("M9512", 1699.95, new MandolinSpec(Builder.FENDER,
                "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, Style.A));
        inventory.addInstrument("M3721", 1699.95, new MandolinSpec(Builder.GIBSON,
                "Gibson", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, Style.F));
    }

    @AfterClass
    public static void setupAfterClass() throws Exception {

    }

    /**
     * 库存中匹配到唯一的吉他、Mandolin
     *
     * @throws Exception
     */
    @Test
    public void testSearchOnly() throws Exception {
        GuitarSpec searchGuitar = new GuitarSpec(Builder.GIBSON, "Gibson", Type.ACOUSTIC, 4,
                Wood.BRAZILIAN_ROSEWOOD, Wood.BRAZILIAN_ROSEWOOD);
        List<Guitar> searchGuitars = inventory.search(searchGuitar);
        String expected = "[Guitar{serialNumber='V3721', price=1599.95, builder='Gibson', model='Gibson', type='Acoustic', numStrings='4', backWood='Brazilian Rosewood', topWood='Brazilian Rosewood'}]";
        Assert.assertEquals(expected, searchGuitars.toString());

        MandolinSpec mandolinSpec = new MandolinSpec(Builder.FENDER, "Gibson", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, Style.F);
        List<Mandolin> searchMandolins = inventory.search(mandolinSpec);
        String expectedMandlins = "[Mandolin{serialNumber='M3721', price=1699.95, builder='Gibson', model='Gibson', type='Electric', backWood='Alder', topWood='Alder', style='F'}]";
        Assert.assertEquals(expectedMandlins, searchMandolins.toString());
    }

    /**
     * 库存中匹配到多个吉他、Mandolin
     *
     * @throws Exception
     */
    @Test
    public void testSearchMultis() throws Exception {
        GuitarSpec searchGuitar = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER);
        List<Guitar> result = inventory.search(searchGuitar);
        String expected = "[Guitar{serialNumber='V95693', price=1499.95, builder='Fender', model='Stratocastor', type='Electric', numStrings='12', backWood='Alder', topWood='Alder'}," +
                " Guitar{serialNumber='V9512', price=1549.95, builder='Fender', model='Stratocastor', type='Electric', numStrings='12', backWood='Alder', topWood='Alder'}]";
        Assert.assertEquals(expected, result.toString());


        MandolinSpec mandolinSpec = new MandolinSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, Style.A);
        List<Mandolin> searchMandolins = inventory.search(mandolinSpec);
        String expectedMandlins = "[Mandolin{serialNumber='M95693', price=1349.95, builder='Fender', model='Stratocastor', type='Electric', backWood='Alder', topWood='Alder', style='A'}," +
                " Mandolin{serialNumber='M9512', price=1699.95, builder='Fender', model='Stratocastor', type='Electric', backWood='Alder', topWood='Alder', style='A'}]";
        Assert.assertEquals(expectedMandlins, searchMandolins.toString());
    }

    /**
     * 库存中没有匹配到
     *
     * @throws Exception
     */
    @Test
    public void testSearchNotExist() throws Exception {
        GuitarSpec guitarSpec = new GuitarSpec(Builder.ANY, "Stratocastor", Type.ELECTRIC, 12, Wood.ALDER, Wood.ALDER);
        List<Guitar> search = inventory.search(guitarSpec);
        String expected = "[]";
        Assert.assertEquals(expected, search.toString());

        MandolinSpec mandolinSpec = new MandolinSpec(Builder.ANY, "Gibson", Type.ELECTRIC, Wood.ALDER, Wood.ALDER, Style.F);
        List<Mandolin> searchMandolins = inventory.search(mandolinSpec);
        String expectedMandlins = "[]";
        Assert.assertEquals(expectedMandlins, searchMandolins.toString());
    }


}
