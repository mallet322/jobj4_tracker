package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {

    public static void main(String[] args) {
        Comparator<String> comparator = (s, anotherString) -> {
            System.out.println("compare - " + anotherString.length() + " : " + s.length());
            return Integer.compare(anotherString.length(), s.length());
        };
        List<String> list = Arrays.asList("w", "bc", "abc", "aaqwertyqweqe", "perona");
        list.sort(comparator);
    }

}
