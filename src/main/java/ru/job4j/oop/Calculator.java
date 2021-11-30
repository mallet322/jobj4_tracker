package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation() {
        return sum(5) + multiply(5) + minus(5) + divide(5);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = Calculator.sum(10);
        System.out.println(result);
        int multiply = calculator.multiply(5);
        System.out.println(multiply);
        int minus = minus(5);
        System.out.println(minus);
        int divide = calculator.divide(5);
        System.out.println(divide);
        int sumAllOperations = calculator.sumAllOperation();
        System.out.println(sumAllOperations);
    }

}
