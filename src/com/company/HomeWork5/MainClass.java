package com.company.HomeWork5;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {


    public static final int CARS_COUNT = 4;
    public static CountDownLatch Start= new  CountDownLatch(CARS_COUNT);
    public static CountDownLatch Finish= new  CountDownLatch(CARS_COUNT);
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    public static Lock winnerLock = new ReentrantLock();


    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));

        }

        for (int i = 0; i < cars.length; i++) {

            new Thread(cars[i]).start();
        }

        try {
            Start.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            Finish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }

}
