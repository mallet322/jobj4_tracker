package ru.job4j.oop.report;

public class JSONReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        return "{".concat(ln)
                  .concat("\"name\"").concat(" : \"").concat(name).concat("\",").concat(ln)
                  .concat("\"body\"").concat(" : \"").concat(body).concat("\"").concat(ln)
                  .concat("}");
    }

}
