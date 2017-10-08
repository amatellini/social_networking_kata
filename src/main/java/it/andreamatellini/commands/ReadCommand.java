package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.MessageRepository;
import it.andreamatellini.utils.DurationFormatter;
import it.andreamatellini.utils.PostDateComparator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadCommand implements Command{

    private String user;
    private MessageRepository messageRepository;
    public ReadCommand(String user, MessageRepository messageRepository) {
        this.user = user;
        this.messageRepository = messageRepository;
    }

    @Override
    public void execute() {
        List<Message> messages = new ArrayList<>();
        messages.addAll(messageRepository.getMessages(user));

        Collections.sort(messages, new PostDateComparator().reversed());

        LocalDateTime now = LocalDateTime.now();

        for (Message message : messages) {
            Duration diff = Duration.between(message.getMessageDate(), now);
            String formattedDiff = DurationFormatter.format(diff);
            System.out.println(String.format("%s - %s (%s)", message.getUser(), message.getMessage(), formattedDiff));
        }
    }
}
