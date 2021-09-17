package ru.job4j.lambda;

import java.util.Comparator;
import java.util.List;

public class CustomComparator {

    public static void stringComparator(List<String> list) {
        Comparator<String> cmpText = (s, anotherString) -> s.compareTo(anotherString);
        list.sort(cmpText);
    }

    public static void stringLengthDescComparator(List<String> list) {
        Comparator<String> cmpDescSize =
                (s, anotherString) -> Integer.compare(anotherString.length(), s.length());
        list.sort(cmpDescSize);
    }

}
