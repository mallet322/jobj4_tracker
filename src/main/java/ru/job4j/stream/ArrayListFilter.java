package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayListFilter {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, -10, 2, -23131, -121, 3, -5);
        List<Integer> newList = filterNegativeNumbers(list);
        newList.forEach(System.out::println);
    }

    public static List<Integer> filterNegativeNumbers(List<Integer> list) {
        return list.stream()
                   .filter(num -> num > 0)
                   .collect(Collectors.toList());
    }

}
