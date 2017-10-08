package it.andreamatellini.commands;

import it.andreamatellini.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

public class WallCommandTest {
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
    public void executeShouldPrintAllTheMessagePostedByAUserAnTheUserThatHeIsFollowing() throws Exception {
        //TODO This test is incomplete. It doesn't test the posts made by the followed user

        new PostCommand(USER, MESSAGE, messageRepository).execute();
        new ReadCommand(USER, messageRepository).execute();

        String actualOutput = outContent.toString("UTF-8");
        assertThat(actualOutput, containsString(USER));
        assertThat(actualOutput, containsString(MESSAGE));
    }
}