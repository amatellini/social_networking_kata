package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.ConnectionRepository;
import it.andreamatellini.repository.MessageRepository;
import it.andreamatellini.utils.PostDateComparator;

import java.util.*;

public class WallCommand implements Command{

    private String user;
    private MessageRepository messageRepository;
    private ConnectionRepository connectionRepository;
    public WallCommand(String user, MessageRepository messageRepository, ConnectionRepository connectionRepository) {
        this.user = user;
        this.messageRepository = messageRepository;
        this.connectionRepository = connectionRepository;
    }

    @Override
    public List<Message> execute() {
        Set<String> users = new HashSet<>();
        users.add(user);
        users.addAll(connectionRepository.getUsersFollowedBy(user));

        List<Message> messages = new ArrayList<>();
        for (String user: users) {
            messages.addAll(messageRepository.getMessages(user));
        }

        Collections.sort(messages, new PostDateComparator().reversed());

        return messages;
    }
}
