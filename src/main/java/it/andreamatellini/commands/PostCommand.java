package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class PostCommand implements Command{

    private String user;
    private String message;
    private MessageRepository messageRepository;
    public PostCommand(String user, String message, MessageRepository messageRepository) {
        this.user = user;
        this.message = message;
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> execute() {
        messageRepository.addMessage(user, new Message(user, LocalDateTime.now(), message));
        return Collections.emptyList();
    }
}
