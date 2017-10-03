package it.andreamatellini.commands;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {

    private static String COMMAND = "some regular expression to be defined";
    private static String EXIT_COMMAND = "exit";

    public static Optional<Command> parse(String command) {
        if (command.trim().equals(EXIT_COMMAND))
            return Optional.of(new ExitCommand());

        Pattern pattern = Pattern.compile(COMMAND);
        Matcher matcher = pattern.matcher(command);
        matcher.matches();

        //TODO creare una o più regular expression al posto di COMMAND
        //TODO implementare gli altri comandi

        return Optional.empty();
    }
}
