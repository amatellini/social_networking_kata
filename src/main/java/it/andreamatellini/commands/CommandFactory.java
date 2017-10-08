package it.andreamatellini.commands;

import it.andreamatellini.repository.ConnectionRepository;
import it.andreamatellini.repository.MessageRepository;

import java.util.Optional;

public class CommandFactory {
    public static Optional<Command> createCommand(String type, String command, MessageRepository messageRepository, ConnectionRepository connectionRepository) {
        if(type == null){
            return null;
        }

        String user;
        String param;

        if(type.equals(CommandType.EXIT)) {
            return Optional.of(new ExitCommand());
        }
        else if(type.equals(CommandType.WALL)) {
            String[] ret = command.split("wall");
            user = ret[0].trim();
            return Optional.of(new WallCommand(user, messageRepository, connectionRepository));
        }
        else if(type.equals(CommandType.FOLLOW)) {
            String[] ret = command.split("follows");
            user = ret[0].trim();
            param = ret[1].trim();
            return Optional.of(new FollowCommand(user, param, connectionRepository));
        }
        else if(type.equals(CommandType.POST)) {
            String[] ret = command.split("->");
            user = ret[0].trim();
            param = ret[1].trim();
            return Optional.of(new PostCommand(user, param, messageRepository));
        }
        else if(type.equals(CommandType.READ)) {
            user = command.trim();
            return Optional.of(new ReadCommand(user, messageRepository));
        }

        return Optional.empty();
    }
}
