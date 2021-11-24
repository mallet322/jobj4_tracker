package ru.job4j.tracker;

import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
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
        try (Store tracker = new SqlTracker()) {
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
