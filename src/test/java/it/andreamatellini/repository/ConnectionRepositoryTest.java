package it.andreamatellini.repository;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ConnectionRepositoryTest {

    private static final String USER = "user";
    private static final String USER_TO_FOLLOW = "user_to_follow";

    ConnectionRepository connectionRepository;

    @Before
    public void setUp() {
        connectionRepository = new ConnectionRepository();
    }

    @Test
    public void followUserShouldAddTheUserToMyUserList() {
        connectionRepository.followUser(USER, USER_TO_FOLLOW);

        Set<String> userIMFollowing = connectionRepository.getUsersIMFollowing(USER);
        assertThat(userIMFollowing, is(not(nullValue())));
        assertThat(userIMFollowing, hasSize(1));
        assertThat(userIMFollowing, contains(USER_TO_FOLLOW));
    }


}