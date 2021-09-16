package ru.job4j.collection.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String el1 = extract2FirstElems(o1);
        String el2 = extract2FirstElems(o2);
        int result = el2.compareTo(el1);
        return result == 0 ? o1.compareTo(o2) : result;
    }

    private String extract2FirstElems(String o) {
        return o.substring(0, 2);
    }

}
