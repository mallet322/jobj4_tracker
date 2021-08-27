package ru.job4j.oop;

public class Point {

    /**
     * Это поле объекта. Оно доступно только конкретному объекту.
     */
    private final int x;

    /**
     * И это поле объекта. Оно доступно только конкретному объекту.
     */
    private final int y;

    /**
     * И это поле объекта. Оно доступно только конкретному объекту.
     */
    private int z;

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    /**
     * Конструктор, который принимает начальное состояние объекта "точка"
     * @param x координата x
     * @param y координата y
     * @param z координата z
     */
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    public double distance3d(Point that) {
        return distance(that) + Math.sqrt(Math.pow(this.z - that.z, 2));
    }

    public void info() {
        System.out.println("Point[" + this.x + ", " + this.y + "]");
    }

}
