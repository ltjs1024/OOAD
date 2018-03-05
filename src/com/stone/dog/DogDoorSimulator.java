package com.stone.dog;


/**
 * 测试类
 */
public class DogDoorSimulator {


    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        BarkReconnizer barkReconnizer = new BarkReconnizer(door);
        Remote remote = new Remote(door);

        // Simulate the hardware hearing a bark
        System.out.println("Fido starts barking.");
        barkReconnizer.recongnize("Woof");

        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("...but he's stuck outside!");

        // Simulate the hardware hearing a bark again.
        System.out.println("\nFido starts barking...");
        barkReconnizer.recongnize("Woof");
        System.out.println("\nFido's back inside...");


    }

}
