package it.andreamatellini.repository;

import it.andreamatellini.message.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MessageRepository {
    private HashMap<String, List<Message>> messageRepository;

    public MessageRepository() {
        messageRepository = new HashMap<>();
    }

    public void addMessage(String user, Message message) {
        List<Message> messages;
        if(messageRepository.get(user) == null) {
            messages = new ArrayList<>();
            messageRepository.put(user, messages);
        }
        else {
            messages = messageRepository.get(user);
        }

        messages.add(message);
    }

    public List<Message> getMessages(String user) {
        List<Message> messages;
        if(messageRepository.get(user) == null) {
            messages = new ArrayList<>();
        }
        else {
            messages = messageRepository.get(user);
        }
        return Collections.unmodifiableList(messages);
    }
 }
