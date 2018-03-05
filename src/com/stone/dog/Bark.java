package com.stone.dog;

public class Bark {

    private String sound;

    public Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bark) {
            Bark otherBark = (Bark) obj;
            if (this.sound.equalsIgnoreCase(otherBark.sound)) {
                return true;
            }
        }

        return false;
    }
}
