package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.ConnectionRepository;

import java.util.Collections;
import java.util.List;

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
    public List<Message> execute() {
        connectionRepository.followUser(user, userToFollow);
        return Collections.emptyList();
    }
}
