package ru.job4j.oop.pojo.library;

public class Library {

    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Head first Java", 300);
        books[1] = new Book("The philosophy of java", 500);
        books[2] = new Book("Clean code", 1000);
        books[3] = new Book("Spring in action", 350);
        System.out.println("Show books info:");
        for (Book book : books) {
            System.out.println("Book name: " + book.getName()
                                       + ", Pages count: " + book.getPageCount());
        }
        swap(books, 0, 3);
        System.out.println(System.lineSeparator() + "Show books info after swap elements:");
        for (Book book : books) {
            System.out.println("Book name: " + book.getName()
                                       + ", Pages count: " + book.getPageCount());
        }
        System.out.println(System.lineSeparator() + "Show books with \"Clean code name\"");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("Book name: " + book.getName()
                                           + ", Pages count: " + book.getPageCount());
            }
        }
    }

    private static void swap(Book[] books, int source, int dest) {
        Book temp = books[source];
        books[source] = books[dest];
        books[dest] = temp;
    }

}
