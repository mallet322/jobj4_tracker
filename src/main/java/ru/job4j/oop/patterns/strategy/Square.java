package ru.job4j.oop.patterns.strategy;

public class Square implements Shape {

    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "**********************".concat(ln)
                                       .concat("*                    *").concat(ln)
                                       .concat("*                    *").concat(ln)
                                       .concat("*                    *").concat(ln)
                                       .concat("*                    *").concat(ln)
                                       .concat("*                    *").concat(ln)
                                       .concat("*                    *").concat(ln)
                                       .concat("**********************");
    }

}
