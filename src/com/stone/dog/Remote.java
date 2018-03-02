package com.stone.dog;

/**
 * 遥控器
 */
public class Remote {

    private DogDoor dogDoor;

    public Remote(DogDoor dogDoor) {
        this.dogDoor = dogDoor;
    }

    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (dogDoor.isOpen()) {
            dogDoor.close();
        }else {
            dogDoor.open();
        }

    }
}
