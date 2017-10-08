package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.ConnectionRepository;
import it.andreamatellini.repository.MessageRepository;
import it.andreamatellini.utils.DurationFormatter;
import it.andreamatellini.utils.PostDateComparator;

import java.time.*;
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
    public void execute() {
        Set<String> users = new HashSet<>();
        users.add(user);
        users.addAll(connectionRepository.getUsersFollowedBy(user));

        List<Message> messages = new ArrayList<>();
        for (String user: users) {
            messages.addAll(messageRepository.getMessages(user));
        }

        Collections.sort(messages, new PostDateComparator().reversed());

        LocalDateTime now = LocalDateTime.now();

        for (Message message : messages) {
            Duration diff = Duration.between(message.getMessageDate(), now);
            String formattedDiff = DurationFormatter.format(diff);
            System.out.println(String.format("%s - %s (%s)", message.getUser(), message.getMessage(), formattedDiff));
        }
    }
}
