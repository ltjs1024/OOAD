package com.stone.guitar;


/**
 * 乐器类
 */
public  class Instrument {



    private final String serialNumber;
    private double price;
    private final InstrumentSpec instrumentSpec;

    public Instrument(String serialNumber, double price, InstrumentSpec instrumentSpec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.instrumentSpec = instrumentSpec;
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


    public InstrumentSpec getSpec() {
        return instrumentSpec;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                "," + instrumentSpec.toString() +
                '}';
    }

}
