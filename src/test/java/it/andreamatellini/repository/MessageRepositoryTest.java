package it.andreamatellini.repository;

import java.time.LocalDateTime;
import java.util.List;
import it.andreamatellini.message.Message;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.equalTo;


public class MessageRepositoryTest {

    private static final String USER = "user";
    private static final String MESSAGE_TEXT = "a message";
    private static final LocalDateTime DATE = LocalDateTime.now();
    private static final Message MESSAGE = new Message(USER, DATE, MESSAGE_TEXT);

    private MessageRepository messageRepository;

    @Before
    public void setUp() {
        messageRepository = new MessageRepository();
    }

    @Test
    public void addMessageShouldAddOneMessage() {
        messageRepository.addMessage(USER, MESSAGE);

        List<Message> messages = messageRepository.getMessages(USER);
        assertThat(messages, is(notNullValue()));
        assertThat(messages, hasSize(1));
    }

    @Test
    public void addMessageShouldAddTheMessage() {
        messageRepository.addMessage(USER, MESSAGE);

        List<Message> messages = messageRepository.getMessages(USER);
        assertThat(messages, is(notNullValue()));
        assertThat(messages, hasSize(1));

        Message message = messages.get(0);
        assertThat(messages, is(notNullValue()));
        assertThat(message.getUser(), is(equalTo(USER)));
        assertThat(message.getMessageDate(), is(equalTo((DATE))));
        assertThat(message.getMessage(), is(equalTo(MESSAGE_TEXT)));
    }

    @Test
    public void addMessageShouldAddAllTheMessages() {
        int numberOfMessages = 3;
        for (int i = 0; i < numberOfMessages; i++) {
            messageRepository.addMessage(USER, MESSAGE);
        }

        List<Message> messages = messageRepository.getMessages(USER);
        assertThat(messages, is(notNullValue()));
        assertThat(messages, is(not(empty())));
        assertThat(messages, hasSize(numberOfMessages));
    }
}