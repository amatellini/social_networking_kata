package it.andreamatellini.commands;

public class WallCommand implements Command{

    private String user;
    public WallCommand(String user) {
        this.user = user;
    }

    @Override
    public void execute() {
        throw new RuntimeException();
    }
}
