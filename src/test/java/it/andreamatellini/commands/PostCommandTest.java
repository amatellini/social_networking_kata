package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostCommandTest {

    private static final String USER = "Bob";
    private static final String MESSAGE = "Damn! We lost! ";

    private MessageRepository messageRepository;

    @Before
    public void setUp() {
        messageRepository = new MessageRepository();
    }

    @Test
    public void executeShouldAddTheMassageToMyMessageList() throws Exception {
        Command postCommand = new PostCommand(USER, MESSAGE, messageRepository);
        postCommand.execute();

        List<Message> messages = messageRepository.getMessages(USER);
        assertThat(messages, is(notNullValue()));
        assertThat(messages, hasSize(1));

        Message message = messages.get(0);
        assertThat(message.getUser(), is(USER));
        assertThat(message.getMessage(), is(MESSAGE));
    }

}