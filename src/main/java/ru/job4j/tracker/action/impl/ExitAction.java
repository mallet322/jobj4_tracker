package ru.job4j.tracker.action.impl;

import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class ExitAction implements UserAction {

    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Exit ===");
        return false;
    }

}
