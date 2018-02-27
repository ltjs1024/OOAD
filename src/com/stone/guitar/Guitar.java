package com.stone.guitar;

/**
 * 吉他
 */
public class Guitar extends Instrument {


    public Guitar(String serialNumber, double price, GuitarSpec guitarSpec) {
        super(serialNumber, price, guitarSpec);
    }


    @Override
    public String toString() {
        GuitarSpec spec = (GuitarSpec) getSpec();
        return "Guitar{" +
                "serialNumber='" + getSerialNumber() + '\'' +
                ", price=" + getPrice() +
                ", builder='" + spec.getBuilder() + '\'' +
                ", model='" + spec.getModel() + '\'' +
                ", type='" + spec.getType() + '\'' +
                ", numStrings='" + spec.getNumStrings() + '\'' +
                ", backWood='" + spec.getBackWood() + '\'' +
                ", topWood='" + spec.getTopWood() + '\'' +
                '}';
    }

}
