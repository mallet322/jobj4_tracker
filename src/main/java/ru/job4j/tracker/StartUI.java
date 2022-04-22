package ru.job4j.tracker;

import java.util.List;

import ru.job4j.tracker.action.impl.CreateAction;
import ru.job4j.tracker.action.impl.DeleteAction;
import ru.job4j.tracker.action.impl.ExitAction;
import ru.job4j.tracker.action.impl.FindAllAction;
import ru.job4j.tracker.action.impl.FindByIdAction;
import ru.job4j.tracker.action.impl.FindByNameAction;
import ru.job4j.tracker.action.impl.ReplaceAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.impl.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.impl.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.impl.MemTracker;
import ru.job4j.tracker.store.Store;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        try {
            while (run) {
                showMenu(actions);
                int select = input.askInt("Select: ");
                if (select < 0 || select >= actions.size()) {
                    out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                    continue;
                }
                UserAction action = actions.get(select);
                run = action.execute(input, tracker);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            UserAction action = actions.get(index);
            out.println(index + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        try (Store tracker = new MemTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new CreateAction(out),
                    new ReplaceAction(out),
                    new DeleteAction(out),
                    new FindAllAction(out),
                    new FindByIdAction(out),
                    new FindByNameAction(out),
                    new ExitAction(out)
            );
            new StartUI(out).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
