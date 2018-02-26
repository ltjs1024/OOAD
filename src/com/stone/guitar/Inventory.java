package com.stone.guitar;

import java.util.ArrayList;
import java.util.List;

/**
 * 吉他库存类
 */

public class Inventory {
    // 库存列表
    private final List<Guitar> guitars;

    public Inventory() {
        this.guitars = new ArrayList<>();
    }

    /**
     * 添加：根据吉他参数，创建吉他对象，并将其加入库存中
     *
     * @param serialNumber
     * @param price
     * @param gurtarSpec
     */
    public void addGuitar(String serialNumber, double price,  GurtarSpec gurtarSpec) {
        Guitar guitar = new Guitar(serialNumber, price,gurtarSpec);
        guitars.add(guitar);
    }

    /**
     * 接受吉他序号，返回该吉他的对象
     *
     * @param serialNumber 吉他序列号
     * @return 返回库存中匹配的吉他对象，没有匹配到则返回null
     */
    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    /**
     * 搜索：接受客户的理想的吉他细节，从库存中匹配并返回所有符合客户规格的所有吉他
     *
     * @param searchGuitar 客户的理想的吉他细节
     * @return 返回符合客户规格的所有吉他
     */
    public List<Guitar> search(Guitar searchGuitar) {
        List<Guitar> result = new ArrayList<>();
        for (Guitar guitar : guitars) {
            GurtarSpec spec = guitar.getSpec();
            if (spec.getBuilder() != searchGuitar.getSpec().getBuilder()) {
                continue;
            }
            String model = guitar.getSpec().getModel();
            if (model != null && !model.equals("") && !model.toLowerCase().equals(searchGuitar.getSpec().getModel().toLowerCase())) {
                continue;
            }
            if (spec.getType() != searchGuitar.getSpec().getType()) {
                continue;
            }
            if (spec.getBackWood() != searchGuitar.getSpec().getBackWood()) {
                continue;
            }
            if (spec.getTopWood() != searchGuitar.getSpec().getTopWood()) {
                continue;
            }
            result.add(guitar);
        }
        return result;
    }
}
