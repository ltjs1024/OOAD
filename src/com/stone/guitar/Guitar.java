package com.stone.guitar;

/**
 * 吉他
 */
public class Guitar {
    private final String serialNumber;
    private double price;
    private final GurtarSpec gurtarSpec;


    public Guitar(String serialNumber, double price, GurtarSpec gurtarSpec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.gurtarSpec = gurtarSpec;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public GurtarSpec getSpec() {
        return gurtarSpec;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", builder='" + gurtarSpec.getBuilder() + '\'' +
                ", model='" + gurtarSpec.getModel() + '\'' +
                ", type='" + gurtarSpec.getType() + '\'' +
                ", backWood='" + gurtarSpec.getBackWood() + '\'' +
                ", topWood='" + gurtarSpec.getTopWood() + '\'' +
                '}';
    }

}
