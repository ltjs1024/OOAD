package com.stone.dog;


/**
 * 测试类
 */
public class DogDoorSimulator {

    public static void main(String[] args) {
        DogDoor dogDoor = new DogDoor();
        Remote remote = new Remote(dogDoor);

        System.out.println("Fido barks to go outside...");
        remote.pressButton();

        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");
        System.out.println("\nFido's back inside...");

    }

}
