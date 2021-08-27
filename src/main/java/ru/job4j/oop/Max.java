package ru.job4j.oop;

public class Max {

    public static int max(int first, int second) {
        return first > second ? first : second;
    }

    public static int max(int first, int second, int third) {
        return (first > second) ? (first > third ? first : third) : (second > third ? second : third);
    }

    public static int max(int first, int second, int third, int fourth) {
        return (first > second && first > third && first > fourth) ?
               first : ((second > third && second > fourth) ?
                        second : (third > fourth ? third : fourth));
    }

}
