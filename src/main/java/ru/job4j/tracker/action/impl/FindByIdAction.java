package ru.job4j.tracker.action.impl;

import java.util.Objects;

import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        out.println(Objects.requireNonNullElseGet(
                item, () -> "Заявка с введенным id: " + id + " не найдена."));
        return true;
    }

}
