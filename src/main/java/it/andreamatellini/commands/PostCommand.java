package it.andreamatellini.commands;

public class PostCommand implements Command{

    private String user;
    private String message;
    public PostCommand(String user, String message) {
        this.user = user;
        this.message = message;
    }

    @Override
    public void execute() {
        throw new RuntimeException();
    }
}
