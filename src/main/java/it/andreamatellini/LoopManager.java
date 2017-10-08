package it.andreamatellini;

import it.andreamatellini.commands.Command;
import it.andreamatellini.commands.CommandFactory;
import it.andreamatellini.commands.CommandParser;
import it.andreamatellini.repository.ConnectionRepository;
import it.andreamatellini.repository.MessageRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Optional;

public class LoopManager {

    PrintStream output;
    BufferedReader bufferedReader;

    public LoopManager() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        output = System.out;
    }

    public void run() {

        MessageRepository messageRepository = new MessageRepository();
        ConnectionRepository connectionRepository = new ConnectionRepository();

        try {
            output.print("> ");
            while(true){
                String commandLine = bufferedReader.readLine();
                String commandType = CommandParser.parse(commandLine);
                Optional<Command> command = CommandFactory.getCommand(commandType, commandLine, messageRepository, connectionRepository);

                if(command.isPresent()) {
                    command.get().execute();
                }

                output.print("> ");
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
