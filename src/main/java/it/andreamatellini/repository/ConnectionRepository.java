package it.andreamatellini.repository;

import java.util.*;

public class ConnectionRepository {
    private  HashMap<String, Set<String>> connectionsRepository;

    public  ConnectionRepository () {
        connectionsRepository = new HashMap<>();
    }

    public void followUser(String user, String userToFollow) {
        Set<String> following;
        if(connectionsRepository.get(user) == null) {
            following = new HashSet<>();
            connectionsRepository.put(user, following);
        }
        else {
            following = connectionsRepository.get(user);
        }

        following.add(userToFollow);

    }

    public Set<String> getUsersFollowedBy(String user) {
        Set<String> following;
        if(connectionsRepository.get(user) == null) {
            following = new HashSet<>();
        }
        else {
            following = connectionsRepository.get(user);
        }
        return Collections.unmodifiableSet(following);
    }

}
