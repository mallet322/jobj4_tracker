package ru.job4j.stream.build;

public class Car {

    private String brand;
    private BodyType bodyType;
    private Double engine;
    private Color color;
    private Integer doorCount;

    public Car() {
    }

    public Car(String brand, BodyType bodyType, Double engine, Color color, Integer doorCount) {
        this.brand = brand;
        this.bodyType = bodyType;
        this.engine = engine;
        this.color = color;
        this.doorCount = doorCount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\''
                + ", bodyType=" + bodyType
                + ", engine=" + engine
                + ", color=" + color
                + ", doorCount=" + doorCount
                + '}';
    }

    static class Builder {
        private String brand;
        private BodyType bodyType;
        private Double engine;
        private Color color;
        private Integer doorCount;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildBodyType(BodyType bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        Builder buildEngine(Double engine) {
            this.engine = engine;
            return this;
        }

        Builder buildColor(Color color) {
            this.color = color;
            return this;
        }

        Builder buildDoorCount(Integer doorCount) {
            this.doorCount = doorCount;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.brand = brand;
            car.bodyType = bodyType;
            car.engine = engine;
            car.color = color;
            car.doorCount = doorCount;
            return car;
        }

    }

}
