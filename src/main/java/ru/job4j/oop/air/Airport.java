package ru.job4j.oop.air;

public class Airport {

    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();
        System.out.println("=================");
        Airbus anotherAirbus = new Airbus("A380");
        System.out.println(anotherAirbus);
        anotherAirbus.printModel();
        anotherAirbus.printCountEngine();
        System.out.println("=================");
        System.out.println("Меняем внутреннее состояние объекта airbus " + airbus.getName() + ":");
        System.out.println(airbus);
        airbus.setName("A380");
        airbus.printModel();
        airbus.printCountEngine();
    }

}
