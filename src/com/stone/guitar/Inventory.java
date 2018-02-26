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
     * @param builder
     * @param model
     * @param type
     * @param backWood
     * @param topWood
     */
    public void addGuitar(String serialNumber, double price, Builder builder, String model,
                          Type type, Wood backWood, Wood topWood) {
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
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
     * 搜索：接受客户的理想的吉他细节，从库存中匹配并返回吉他对象
     *
     * @param searchGuitar 客户的理想的吉他细节
     * @return 返回库存中匹配的吉他对象， 没有匹配到则返回null
     */
    public Guitar search(Guitar searchGuitar) {
        for (Guitar guitar : guitars) {
            if (guitar.getBuilder() != searchGuitar.getBuilder()) {
                continue;
            }
            String model = guitar.getModel();
            if (model != null && !model.equals("") && !model.toLowerCase().equals(searchGuitar.getModel().toLowerCase())) {
                continue;
            }
            if (guitar.getType() != searchGuitar.getType()) {
                continue;
            }
            if (guitar.getBackWood() != searchGuitar.getBackWood()) {
                continue;
            }
            if (guitar.getTopWood() != searchGuitar.getTopWood()) {
                continue;
            }
            return guitar;
        }
        return null;
    }
}
