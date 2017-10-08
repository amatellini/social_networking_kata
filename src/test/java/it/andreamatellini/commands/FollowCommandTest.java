package it.andreamatellini.commands;

import it.andreamatellini.repository.ConnectionRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FollowCommandTest {

    private static final String USER = "Alice";
    private static final String USER_TO_FOLLOW = "Charlie";

    private ConnectionRepository connectionRepository;

    @Before
    public void setUp() {
        connectionRepository = new ConnectionRepository();
    }

    @Test
    public void executeShouldAddTheUserToMyConnectionList() {
        FollowCommand followCommand = new FollowCommand(USER, USER_TO_FOLLOW, connectionRepository);
        followCommand.execute();

        Set<String> following = connectionRepository.getUsersFollowedBy(USER);
        assertThat(following, is(notNullValue()));
        assertThat(following, hasSize(1));
        assertThat(following, contains(USER_TO_FOLLOW));
    }
}