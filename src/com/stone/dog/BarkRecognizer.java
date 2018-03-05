package com.stone.dog;

import java.util.List;

public class BarkRecognizer {

    private DogDoor door;

    public BarkRecognizer(DogDoor dogDoor) {
        this.door = dogDoor;
    }

    public void recongnize(Bark bark) {
        List<Bark> allowedBarks = door.getAllowedBarks();
        for (Bark allowedBark : allowedBarks) {
            if (bark.equals(allowedBark)) {
                System.out.println("  BarkRecongnizer: Head a '" + bark.getSound() + "'");
                door.open();
                return;
            } else {
                System.out.println("This dog is not allowed.");
            }
        }

    }
}
