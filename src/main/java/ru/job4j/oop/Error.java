package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo(boolean active, int status, String message) {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error0 = new Error();
        error0.printInfo(error0.active, error0.status, error0.message);
        Error error1 = new Error(true, 1, "First message!");
        error1.printInfo(error1.active, error1.status, error1.message);
        Error error2 = new Error(false, 2, "Second message!");
        error2.printInfo(error2.active, error2.status, error2.message);
    }

}
