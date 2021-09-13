package ru.job4j.oop.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Bus driving.");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Passengers count: " + count);
    }

    @Override
    public int fillUp(int fuelCount) {
        int fuelPrice = Math.round(50.49f);
        return fuelPrice * fuelCount;
    }

}
