package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        int rate = 1;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            while (matches > 3 || matches < 1) {
                System.out.println("Некоррктный ввод, повторите попытку.");
                System.out.println(player + " введите число от 1 до 3:");
                System.out.println();
                matches = Integer.parseInt(input.nextLine());
            }
            count = count - matches;
            rate++;
            turn = rate % 2 == 0;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
