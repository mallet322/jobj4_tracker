package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery = new Battery(11);
        Battery another = new Battery(9);
        battery.exchange(another);
        printLoad(battery);
        printLoad(another);
    }

    private static void printLoad(Battery battery) {
        System.out.println("Load: " + battery.load);
    }

}
