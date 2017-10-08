package it.andreamatellini.commands;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Hasta la vista baby!");
        System.exit(0);
    }
}
