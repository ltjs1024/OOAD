package com.stone.guitar;

import java.util.ArrayList;
import java.util.List;

/**
 * 吉他库存类
 */

public class Inventory {
    // 库存列表
    private final List<Instrument> instruments;

    public Inventory() {
        this.instruments = new ArrayList<>();
    }

    /**
     * 添加：根据乐器参数，创建乐器对象，并将其加入库存中
     *
     * @param serialNumber
     * @param price
     * @param instrumentSpec
     */
    public void addInstrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        Instrument instrument = null;
        if (instrumentSpec instanceof GuitarSpec) {
            instrument = new Guitar(serialNumber, price, (GuitarSpec) instrumentSpec);
        } else if (instrumentSpec instanceof MandolinSpec) {
            instrument = new Mandolin(serialNumber, price, (MandolinSpec) instrumentSpec);
        }
        instruments.add(instrument);
    }

    /**
     * 接受乐器序列号，返回该乐器的对象
     *
     * @param serialNumber 乐器序列号
     * @return 返回库存中匹配的乐器对象，没有匹配到则返回null
     */
    public Instrument getInstrument(String serialNumber) {
        for (Instrument instrument : instruments) {
            if (instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    /**
     * 搜索：接受客户的理想的吉他细节，从库存中匹配并返回所有符合客户规格的所有吉他
     *
     * @param searchSpec 客户的理想的吉他细节
     * @return 返回符合客户规格的所有吉他
     */
    public List<Guitar> search(GuitarSpec searchSpec) {
        List<Guitar> result = new ArrayList<>();
        for (Instrument instrument : instruments) {
            if (searchSpec.matches(instrument.getSpec())) {
                result.add((Guitar) instrument);
            }
        }
        return result;
    }

    /**
     * 搜索：接受客户的理想的Mandolin细节，从库存中匹配并返回所有符合客户规格的所有Mandolin
     *
     * @param searchSpec 客户的理想的Mandolin细节
     * @return 返回符合客户规格的所有Mandolin
     */
    public List<Mandolin> search(MandolinSpec searchSpec) {
        List<Mandolin> result = new ArrayList<>();
        for (Instrument instrument : instruments) {
            if (searchSpec.matches(instrument.getSpec())) {
                result.add((Mandolin) instrument);
            }
        }
        return result;
    }
}
