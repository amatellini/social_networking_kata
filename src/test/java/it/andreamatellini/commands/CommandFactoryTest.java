package it.andreamatellini.commands;

import it.andreamatellini.repository.ConnectionRepository;
import it.andreamatellini.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class CommandFactoryTest {

    private static final String EXIT_COMMAND = "exit";
    private static final String WALL_COMMAND = "Charlie wall";
    private static final String FOLLOW_COMMAND = "Charlie follows Alice";
    private static final String POST_COMMAND = "Alice -> I love the weather today";
    private static final String READ_COMMAND = "Charlie";
    private static final String INVALID_COMMAND = "zajsjd@ddd@wwe";

    private MessageRepository messageRepository;
    private ConnectionRepository connectionRepository;

    @Before
    public void setUp() {
        messageRepository = new MessageRepository();
        connectionRepository = new ConnectionRepository();
    }

    @Test
    public void createCommandWithTypeEXITShouldReturnAnExitCommand() {
        Optional<Command> exitCommand = CommandFactory.createCommand(CommandType.EXIT, EXIT_COMMAND, messageRepository, connectionRepository);
        assertThat(exitCommand.isPresent(), is(true));
        assertThat(exitCommand.get(), is(instanceOf(ExitCommand.class)));
    }

    @Test
    public void createCommandWithTypeWALLShouldReturnAWallCommand() {
        Optional<Command> wallCommand = CommandFactory.createCommand(CommandType.WALL, WALL_COMMAND, messageRepository, connectionRepository);
        assertThat(wallCommand.isPresent(), is(true));
        assertThat(wallCommand.get(), is(instanceOf(WallCommand.class)));
    }

    @Test
    public void createCommandWithTypeFOLLOWShouldReturnAFollowCommand() {
        Optional<Command> followCommand = CommandFactory.createCommand(CommandType.FOLLOW, FOLLOW_COMMAND, messageRepository, connectionRepository);
        assertThat(followCommand.isPresent(), is(true));
        assertThat(followCommand.get(), is(instanceOf(FollowCommand.class)));
    }

    @Test
    public void createCommandWithTypePOSTShouldReturnAPostCommand() {
        Optional<Command> postCommand = CommandFactory.createCommand(CommandType.POST, POST_COMMAND, messageRepository, connectionRepository);
        assertThat(postCommand.isPresent(), is(true));
        assertThat(postCommand.get(), is(instanceOf(PostCommand.class)));
    }

    @Test
    public void createCommandWithTypeREADShouldReturnAPostCommand() {
        Optional<Command> readCommand = CommandFactory.createCommand(CommandType.READ, READ_COMMAND, messageRepository, connectionRepository);
        assertThat(readCommand.isPresent(), is(true));
        assertThat(readCommand.get(), is(instanceOf(ReadCommand.class)));
    }

    @Test
    public void createCommandWithInvalidCommandShouldNotReturnACommand() {
        Optional<Command> invalidCommand = CommandFactory.createCommand(INVALID_COMMAND, INVALID_COMMAND, messageRepository, connectionRepository);
        assertThat(invalidCommand.isPresent(), is(false));
    }

}