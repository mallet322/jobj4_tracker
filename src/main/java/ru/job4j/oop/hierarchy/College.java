package ru.job4j.oop.hierarchy;

public class College {

    /**
     * Приведения класса {@link Freshman} к {@link Student} и {@link Object)/
     * В данном примере повышающие приведения типов (upCasting).
     * @param args Аргументы.
     */
    public static void main(String[] args) {
        Freshman fr = new Freshman();
        Student student = fr;
        Object obj = fr;
    }
}
