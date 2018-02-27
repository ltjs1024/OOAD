package com.stone.guitar;

/**
 * 各种具体乐器
 */
public enum InstrumentType {
    GUITAR,
    MANDOLIN,
    BANJO,
    DOBRO,
    FIDDLE,
    BASS;

    @Override
    public String toString() {
        switch (this) {
            case GUITAR:
                return "Guitar";
            case MANDOLIN:
                return "Mandolin";
            case BANJO:
                return "Banjo";
            case DOBRO:
                return "Dobro";
            case FIDDLE:
                return "Fiddle";
            case BASS:
                return "Bass";
            default:
                return "Undefined";
        }
    }
}
