package com.cathaybk.multiThreadTest;

/**
 * @author RogerLo
 * @date 2023/1/17
 */
public class Multi_Test extends Thread {

    private String name;

    public Multi_Test(String str) {
        this.name = str;
    }

    @Override
    public void run() {
        this.show();
    }

    public void show() {
        // for (int i = 0; i < 3; i++) {
        //     // try {
        //     //     sleep( (int) (1000 * Math.random()));
        //     // } catch (InterruptedException e) {
        //     //     // throw new RuntimeException(e);
        //     // }
        // }
        System.out.println("Thread - " + name + "， Priority: " + this.getPriority());
    }

    public static void main(String[] args) {

        Multi_Test apple = new Multi_Test("Red");
        Multi_Test banana = new Multi_Test("Yellow");
        Multi_Test grape = new Multi_Test("Purple");
        Multi_Test cloud = new Multi_Test("White");
        Multi_Test grass = new Multi_Test("Green");

        apple.setPriority(Thread.MAX_PRIORITY);
        banana.setPriority(Thread.MIN_PRIORITY);
        cloud.setPriority(3);
        grass.setPriority(6);

        apple.start();
        banana.start();
        grape.start();
        cloud.start();
        grass.start();
    }
}
