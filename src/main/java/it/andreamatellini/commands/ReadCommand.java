package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.MessageRepository;
import it.andreamatellini.utils.PostDateComparator;

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
    public List<Message> execute() {
        List<Message> messages = new ArrayList<>();
        messages.addAll(messageRepository.getMessages(user));

        Collections.sort(messages, new PostDateComparator().reversed());

        return messages;
    }
}
