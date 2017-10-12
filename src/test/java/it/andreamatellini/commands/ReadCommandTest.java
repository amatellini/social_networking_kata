package it.andreamatellini.commands;

import it.andreamatellini.message.Message;
import it.andreamatellini.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ReadCommandTest {

    private static final String USER = "Bob";
    private static final String MESSAGE = "Damn! We lost! ";

    private MessageRepository messageRepository;
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        messageRepository = new MessageRepository();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void executeShouldPrintAllTheMessagePostedByAUser() throws Exception {
        new PostCommand(USER, MESSAGE, messageRepository).execute();
        List<Message> output = new ReadCommand(USER, messageRepository).execute();

        assertThat(output, is(notNullValue()));
        assertThat(output, hasSize(1));

        Message message = output.get(0);

        assertThat(message.getUser(), is(USER));
        assertThat(message.getMessage(), is(MESSAGE));
    }
}