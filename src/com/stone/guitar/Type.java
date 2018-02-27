package com.stone.guitar;

/**
 * 乐器类型：
 *      原声吉他
 *      电吉他
 */
public enum Type {
    ACOUSTIC, ELECTRIC;

    @Override
    public String toString() {
        switch (this) {
            case ACOUSTIC:
                return "Acoustic";
            case ELECTRIC:
                return "Electric";
            default:
                return "Undefined";
        }
    }
}
