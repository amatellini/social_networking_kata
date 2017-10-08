package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.ConnectionRepository;
import it.andreamatellini.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PostCommandTest {

    private static final String USER = "Bob";
    private static final String MESSAGE = "Damn! We lost! ";

    private MessageRepository messageRepository;

    @Before
    public void setUp() {
        messageRepository = new MessageRepository();
    }

    @Test
    public void execute() throws Exception {
        Command followCommand = new PostCommand(USER, MESSAGE, messageRepository);
        followCommand.execute();

        List<Message> messages = messageRepository.getMessages(USER);
        assertThat(messages, is(notNullValue()));
        assertThat(messages, hasSize(1));

        Message message = messages.get(0);
        assertThat(message.getUser(), is(USER));
        assertThat(message.getMessage(), is(MESSAGE));
    }

}