package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = Calculator.sum(10);
        System.out.println(result);
        int multiply = calculator.multiply(5);
        System.out.println(multiply);
        int minus = minus(5);
        System.out.println(minus);
        double divide = calculator.divide(5);
        System.out.println(divide);
        double sumAllOperations = calculator.sumAllOperation();
        System.out.println(sumAllOperations);
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public double divide(int a) {
        return (double) a / x;
    }

    public double sumAllOperation() {
        return (double) (sum(5) + multiply(5) + minus(5)) + divide(5);
    }

}
