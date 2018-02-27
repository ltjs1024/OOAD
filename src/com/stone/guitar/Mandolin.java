package com.stone.guitar;

/**
 * 曼陀林
 */
public class Mandolin extends Instrument {

    public Mandolin(String serialNumber, double price, MandolinSpec mandolinSpec) {
        super(serialNumber, price, mandolinSpec);
    }

    @Override
    public String toString() {
        MandolinSpec spec = (MandolinSpec) getSpec();
        return "Mandolin{" +
                "serialNumber='" + getSerialNumber() + '\'' +
                ", price=" + getPrice() +
                ", builder='" + spec.getBuilder() + '\'' +
                ", model='" + spec.getModel() + '\'' +
                ", type='" + spec.getType() + '\'' +
                ", backWood='" + spec.getBackWood() + '\'' +
                ", topWood='" + spec.getTopWood() + '\'' +
                ", style='" + spec.getStyle() + '\'' +
                '}';
    }
}
