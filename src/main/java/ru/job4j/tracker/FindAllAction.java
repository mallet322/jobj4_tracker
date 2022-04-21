package ru.job4j.tracker;

public class FindAllAction implements UserAction {

    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws InterruptedException {
        out.println("=== Show all items ===");
        tracker.findAllByReact(System.out::println);
        return true;
    }

}
