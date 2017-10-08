package it.andreamatellini.commands;

import it.andreamatellini.repository.ConnectionRepository;

public class FollowCommand implements Command{

    private String user;
    private String userToFollow;
    private ConnectionRepository connectionRepository;
    public FollowCommand(String user, String userToFollow, ConnectionRepository connectionRepository) {
        this.user = user;
        this.userToFollow = userToFollow;
        this.connectionRepository = connectionRepository;
    }

    @Override
    public void execute() {
        connectionRepository.followUser(user, userToFollow);
    }
}
