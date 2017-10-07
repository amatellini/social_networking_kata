package it.andreamatellini.commands;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    private static String FOLLOW_COMMAND = "\\s*follows\\s.*";
    private static String WALL_COMMAND = "\\s*wall";
    private static String EXIT_COMMAND = "exit";

    private static HashMap<String, String> commandMatchers = new HashMap<>();

    static {
        //TODO manca il comando per i post
        commandMatchers.put(EXIT_COMMAND, Command.EXIT);
        commandMatchers.put(WALL_COMMAND, Command.WALL);
        commandMatchers.put(FOLLOW_COMMAND, Command.FOLLOW);
    }

    public static Optional<Command> parse(String command) {

        for(String key : commandMatchers.keySet()){
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(command);
            if(matcher.matches()) {
                String type = commandMatchers.get(key);
                return Optional.of(CommandFactory.getCommand(type));
            }
        }

        //TODO implementare i comandi

        return Optional.empty();
    }
}
