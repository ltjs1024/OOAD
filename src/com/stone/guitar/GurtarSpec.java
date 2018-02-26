package com.stone.guitar;

/**
 * Gurtar一般特性
 */
public class GurtarSpec {
    private final Builder builder;//制造商
    private final String model;//型号
    private final Type type;//类型
    private final Wood backWood;//back木料
    private final Wood topWood;//top木料

    public GurtarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }
}
