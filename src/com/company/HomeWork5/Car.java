package com.company.HomeWork5;

import java.util.concurrent.CountDownLatch;


public class Car<isWinner> implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;

    }

    private Race race;
    private int speed;
    private String name;
    private static boolean isWinner;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

    }

    @Override
    public void run() {


        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));

            System.out.println(this.name + " готов");
            MainClass.Start.countDown();
            MainClass.cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {



            race.getStages().get(i).go(this);
        }
        MainClass.winnerLock.lock();
        if (!isWinner) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + this.name + " - ПОБЕДИТЕЛЬ!!!");
        isWinner = true;
    }
        MainClass.winnerLock.unlock();
        MainClass.Finish.countDown();
    }
}
