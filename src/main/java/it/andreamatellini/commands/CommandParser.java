package it.andreamatellini.commands;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    private static String FOLLOW_COMMAND = ".*\\sfollows\\s.*";
    private static String WALL_COMMAND = ".*\\swall";
    private static String EXIT_COMMAND = "exit";
    private static String POST_COMMAND = ".*\\s->\\s.*";
    private static String READ_COMMAND = ".*";

    private static HashMap<String, String> commandMatchers = new HashMap<>();

    static {
        commandMatchers.put(EXIT_COMMAND, CommandType.EXIT);
        commandMatchers.put(WALL_COMMAND, CommandType.WALL);
        commandMatchers.put(FOLLOW_COMMAND, CommandType.FOLLOW);
        commandMatchers.put(POST_COMMAND, CommandType.POST);
        commandMatchers.put(READ_COMMAND, CommandType.READ);
    }

    public static String parse(String command) {

        for(String key : commandMatchers.keySet()){
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(command);
            if(matcher.matches()) {
                return commandMatchers.get(key);
            }
        }
        return "";
    }
}
