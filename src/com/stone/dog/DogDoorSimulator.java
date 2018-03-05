package com.stone.dog;


/**
 * 测试类
 */
public class DogDoorSimulator {


    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.addAllowedBark(new Bark("woof"));
        door.addAllowedBark(new Bark("wowo"));
        BarkRecognizer barkReconnizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);

        // Simulate the hardware hearing a bark
        System.out.println("Fido starts barking.");
        Bark woof = new Bark("Woof");
        barkReconnizer.recongnize(woof);

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
        barkReconnizer.recongnize(woof);
        System.out.println("\nFido's back inside...");


    }

}
