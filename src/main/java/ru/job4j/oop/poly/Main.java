package ru.job4j.oop.poly;

public class Main {

    public static void main(String[] args) {
        Bus busInfo = new Bus();
        busInfo.drive();
        busInfo.passengers(32);
        int fuelPrice = busInfo.fillUp(50);
        System.out.println("Fuel price: " + fuelPrice);
    }

}
