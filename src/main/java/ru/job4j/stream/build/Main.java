package ru.job4j.stream.build;

public class Main {

    public static void main(String[] args) {
        Car car = new Car.Builder().buildBrand("Lada")
                                   .buildBodyType(BodyType.Sedan)
                                   .buildEngine(1.6)
                                   .buildColor(Color.Grey)
                                   .buildDoorCount(4)
                                   .build();
        System.out.println(car);
    }

}
