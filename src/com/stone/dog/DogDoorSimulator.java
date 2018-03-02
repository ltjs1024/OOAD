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

        try {
            Thread.currentThread().sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("...but he's stuck outside!");
        System.out.println("\nFido starts barking...");
        System.out.println("...so Gina grabs the remote control.");
        remote.pressButton();
        System.out.println("\nFido's back inside...");


    }

}
