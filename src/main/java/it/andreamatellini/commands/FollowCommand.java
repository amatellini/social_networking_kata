package it.andreamatellini.commands;

public class FollowCommand implements Command{

    private String user;
    private String userToFollow;
    public FollowCommand(String user, String userToFollow) {
        this.user = user;
        this.userToFollow = userToFollow;
    }

    @Override
    public void execute() {
        throw new RuntimeException();
    }
}
