package com.stone.dog;

import java.util.Timer;
import java.util.TimerTask;

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
        } else {
            dogDoor.open();
            // 5秒后自动关门
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    dogDoor.close();
                    timer.cancel();
                }
            }, 5000);
        }

    }
}
