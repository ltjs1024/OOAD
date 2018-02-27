package com.stone.guitar;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GuitarTest {

    private static Inventory inventory;

    @BeforeClass
    public static void setupBeforeClass() throws Exception {
        inventory = new Inventory();
        initializeInventory(inventory);
    }

    private static void initializeInventory(Inventory inventory) {
        // 添加Guitar
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "Gibson");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 4);
        properties.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        properties.put("topWood", Wood.BRAZILIAN_ROSEWOOD);
        inventory.addInstrument("V3721", 1599.95, new InstrumentSpec(properties));

        properties = new LinkedHashMap<>();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("numStrings", 12);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));

        properties = new LinkedHashMap<>();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("numStrings", 12);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

        // 添加Mandolin
        properties = new LinkedHashMap<>();
        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        properties.put("style", Style.A);
        inventory.addInstrument("M95693", 1349.95, new InstrumentSpec(properties));

        properties = new LinkedHashMap<>();
        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        properties.put("style", Style.A);
        inventory.addInstrument("M9512", 1699.95, new InstrumentSpec(properties));

        properties = new LinkedHashMap<>();
        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "Gibson");
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        properties.put("style", Style.F);
        inventory.addInstrument("M3721", 1699.95, new InstrumentSpec(properties));
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
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "Gibson");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 4);
        properties.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        properties.put("topWood", Wood.BRAZILIAN_ROSEWOOD);
        InstrumentSpec searchGuitar = new InstrumentSpec(properties);
        List<Instrument> searchGuitars = inventory.search(searchGuitar);
        String expected = "[Instrument{serialNumber='V3721', price=1599.95, instrumentType='Guitar', builder='Gibson', model='Gibson', type='Acoustic', numStrings='4', backWood='Brazilian Rosewood', topWood='Brazilian Rosewood'}]";
        Assert.assertEquals(expected, searchGuitars.toString());

        properties = new LinkedHashMap<>();
        properties.put("builder", Builder.GIBSON);
        properties.put("model", "Gibson");
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        properties.put("style", Style.F);
        InstrumentSpec instrumentSpec = new InstrumentSpec(properties);
        List<Instrument> searchMandolins = inventory.search(instrumentSpec);
        String expectedMandlins = "[Instrument{serialNumber='M3721', price=1699.95, instrumentType='Mandolin', builder='Gibson', model='Gibson', type='Electric', backWood='Alder', topWood='Alder', style='F'}]";
        Assert.assertEquals(expectedMandlins, searchMandolins.toString());
    }

    /**
     * 库存中匹配到多个吉他、Mandolin
     *
     * @throws Exception
     */
    @Test
    public void testSearchMultis() throws Exception {
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("numStrings", 12);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        InstrumentSpec spec = new InstrumentSpec(properties);
        List<Instrument> result = inventory.search(spec);
        String expected = "[Instrument{serialNumber='V95693', price=1499.95, instrumentType='Guitar', builder='Fender', model='Stratocastor', type='Electric', numStrings='12', backWood='Alder', topWood='Alder'}," +
                " Instrument{serialNumber='V9512', price=1549.95, instrumentType='Guitar', builder='Fender', model='Stratocastor', type='Electric', numStrings='12', backWood='Alder', topWood='Alder'}]";
        Assert.assertEquals(expected, result.toString());

        properties = new LinkedHashMap<>();
        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        properties.put("style", Style.A);
        InstrumentSpec instrumentSpec = new InstrumentSpec(properties);
        List<Instrument> searchMandolins = inventory.search(instrumentSpec);
        String expectedMandlins = "[Instrument{serialNumber='M95693', price=1349.95, instrumentType='Mandolin', builder='Fender', model='Stratocastor', type='Electric', backWood='Alder', topWood='Alder', style='A'}," +
                " Instrument{serialNumber='M9512', price=1699.95, instrumentType='Mandolin', builder='Fender', model='Stratocastor', type='Electric', backWood='Alder', topWood='Alder', style='A'}]";
        Assert.assertEquals(expectedMandlins, searchMandolins.toString());
    }

    /**
     * 库存中没有匹配到
     *
     * @throws Exception
     */
    @Test
    public void testSearchNotExist() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put("builder", Builder.ANY);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("numStrings", 12);
        properties.put("backWood", Wood.BRAZILIAN_ROSEWOOD);
        properties.put("topWood", Wood.BRAZILIAN_ROSEWOOD);
        InstrumentSpec searchGuitar = new InstrumentSpec(properties);
        List<Instrument> result = inventory.search(searchGuitar);
        String expected = "[]";
        Assert.assertEquals(expected, result.toString());

        properties = new HashMap<>();
        properties.put("builder", Builder.ANY);
        properties.put("model", "Gibson");
        properties.put("type", Type.ELECTRIC);
        properties.put("backWood", Wood.ALDER);
        properties.put("topWood", Wood.ALDER);
        properties.put("style", Style.F);
        InstrumentSpec instrumentSpec = new InstrumentSpec(properties);
        List<Instrument> searchMandolins = inventory.search(instrumentSpec);
        String expectedMandlins = "[]";
        Assert.assertEquals(expectedMandlins, searchMandolins.toString());
    }


}
