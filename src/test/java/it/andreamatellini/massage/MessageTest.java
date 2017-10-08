package it.andreamatellini.massage;

import it.andreamatellini.message.Message;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class MessageTest {

    private static final String USER = "user";
    private static final LocalDateTime POST_DATE = LocalDateTime.now();
    private static final String MESSAGE = "the message";
    private Message message = new Message(USER, POST_DATE, MESSAGE);

    @Test
    public void getUserShouldReturnTheUser() {
        assertEquals(message.getUser(), USER);
    }

    @Test
    public void getMessageDateShouldReturnThePostDate() {
        assertEquals(message.getMessageDate(), POST_DATE);
    }

    @Test
    public void getMessageShouldRetunTheMessage() {
        assertEquals(message.getMessage(), MESSAGE);
    }
}