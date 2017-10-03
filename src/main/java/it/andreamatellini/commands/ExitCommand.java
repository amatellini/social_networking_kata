package it.andreamatellini.commands;

public class ExitCommand implements Command {
    @Override
    public void execute(String command) {
        System.out.println("Hasta la vista baby!");
        System.exit(0);
    }
}
