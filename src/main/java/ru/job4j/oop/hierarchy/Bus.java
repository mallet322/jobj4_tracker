package ru.job4j.oop.hierarchy;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по дорогам");
    }

}
