package ru.job4j.oop.report;

public class HtmlReport extends TextReport {

    @Override
    public String generate(String name, String body) {
        return "<h1>".concat(name).concat("</h1>")
                     .concat("<br/>")
                     .concat("<span>").concat(body).concat("</span>");
    }

}
