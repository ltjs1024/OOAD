package com.stone.dog;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 狗门：连接硬件的接口
 */
public class DogDoor {
    private boolean open;
    private List<Bark> allowedBarks = new ArrayList<>();

    public DogDoor() {
        this.open = false;
    }

    public void addAllowedBark(Bark allowedBark) {
        if (allowedBark != null) {
            allowedBarks.add(allowedBark);
        }
    }

    public List<Bark> getAllowedBarks() {
        return this.allowedBarks;
    }

    public void open() {
        System.out.println("The dog door opens.");
        this.open = true;

        // 5秒后自动关门
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
                timer.cancel();
            }
        }, 5000);
    }

    public void close() {
        System.out.println("The dog door closes.");
        this.open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
