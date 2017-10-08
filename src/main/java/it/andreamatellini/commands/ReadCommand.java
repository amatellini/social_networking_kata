package it.andreamatellini.commands;

public class ReadCommand implements Command{

    private String user;
    public ReadCommand(String user) {
        this.user = user;
    }

    @Override
    public void execute() {
        throw new RuntimeException();
    }
}
