package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.ConnectionRepository;
import it.andreamatellini.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WallCommandTest {
    private static final String USER1 = "Bob";
    private static final String MESSAGE1 = "Damn! We lost! ";

    private static final String USER2 = "Alice";
    private static final String MESSAGE2 = "I love the weather today";

    private MessageRepository messageRepository;
    private ConnectionRepository connectionRepository;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        messageRepository = new MessageRepository();
        connectionRepository = new ConnectionRepository();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void executeShouldPrintAllTheMessagePostedByAUserAnTheUserThatHeIsFollowing() throws Exception {
        new PostCommand(USER1, MESSAGE1, messageRepository).execute();
        new PostCommand(USER2, MESSAGE2, messageRepository).execute();
        new FollowCommand(USER1, USER2, connectionRepository).execute();

        List<Message> output = new WallCommand(USER1, messageRepository, connectionRepository).execute();

        assertThat(output, is(notNullValue()));
        assertThat(output, hasSize(2));
    }
}