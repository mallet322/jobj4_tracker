package ru.job4j.tracker.action;

public interface Observe<T> {

    void receive(T model);

}
