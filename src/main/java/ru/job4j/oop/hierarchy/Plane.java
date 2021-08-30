package ru.job4j.oop.hierarchy;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по воздуху");
    }

}
