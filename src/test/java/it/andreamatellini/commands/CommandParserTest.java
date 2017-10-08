package it.andreamatellini.commands;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CommandParserTest {

    private static final String EXIT_COMMAND = "exit";
    private static final String WALL_COMMAND = "Charlie wall";
    private static final String FOLLOW_COMMAND = "Charlie follows Alice";
    private static final String POST_COMMAND = "Alice -> I love the weather today";
    private static final String READ_COMMAND = "Charlie";
    private static final String INVALID_COMMAND = "zajsjd@ddd@wwe";

    @Test
    public void parseAnExitCommandShouldReturnATypeEXIT() throws Exception {
        String commandType = CommandParser.parse(EXIT_COMMAND);
        assertThat(commandType, is(not(nullValue())));
        assertThat(commandType, is(CommandType.EXIT));
    }

    @Test
    public void parseAWallCommandShouldReturnATypeWALL() throws Exception {
        String commandType = CommandParser.parse(WALL_COMMAND);
        assertThat(commandType, is(not(nullValue())));
        assertThat(commandType, is(CommandType.WALL));
    }

    @Test
    public void parseAFollowCommandShouldReturnATypeFOLLOW() throws Exception {
        String commandType = CommandParser.parse(FOLLOW_COMMAND);
        assertThat(commandType, is(not(nullValue())));
        assertThat(commandType, is(CommandType.FOLLOW));
    }

    @Test
    public void parseAPostCommandShouldReturnATypePOST() throws Exception {
        String commandType = CommandParser.parse(POST_COMMAND);
        assertThat(commandType, is(not(nullValue())));
        assertThat(commandType, is(CommandType.POST));
    }

    @Test
    public void parseAReadCommandShouldReturnATypeREAD() throws Exception {
        String commandType = CommandParser.parse(READ_COMMAND);
        assertThat(commandType, is(not(nullValue())));
        assertThat(commandType, is(CommandType.READ));
    }

    @Test
    public void parseAnInvalidCommandShouldReturnATypeREAD() throws Exception {
        String commandType = CommandParser.parse(INVALID_COMMAND);
        assertThat(commandType, is(not(nullValue())));
        assertThat(commandType, is(CommandType.READ));
    }

}