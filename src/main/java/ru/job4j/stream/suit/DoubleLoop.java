package ru.job4j.stream.suit;

import java.util.stream.Stream;

public class DoubleLoop {

    public static void main(String[] args) {
        Suit[] suits = {Suit.Diamonds, Suit.Hearts, Suit.Spades, Suit.Clubs};
        Value[] values = {Value.V_6, Value.V_7, Value.V_8};
        Stream.of(suits)
              .flatMap(suit -> Stream.of(values)
                                     .map(value -> suit + " " + value))
              .forEach(System.out::println);
    }

}
