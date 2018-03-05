package com.stone.dog;

public class BarkReconnizer {

    private DogDoor door;

    public BarkReconnizer(DogDoor dogDoor) {
        this.door = dogDoor;
    }

    public void recongnize(String bark) {
        System.out.println("  BarkRecongnizer: Head a '" + bark + "'");
        door.open();
    }
}
