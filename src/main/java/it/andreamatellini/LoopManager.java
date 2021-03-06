package it.andreamatellini;

import it.andreamatellini.commands.Command;
import it.andreamatellini.commands.CommandFactory;
import it.andreamatellini.commands.CommandParser;
import it.andreamatellini.message.Message;
import it.andreamatellini.repository.ConnectionRepository;
import it.andreamatellini.repository.MessageRepository;
import it.andreamatellini.utils.MessageFormatter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;
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
                Optional<Command> command = CommandFactory.createCommand(commandType, commandLine, messageRepository, connectionRepository);

                if(command.isPresent()) {
                    LocalDateTime now = LocalDateTime.now();
                    List<Message> ret = command.get().execute();

                    Optional.ofNullable(ret)
                            .ifPresent(v -> v.forEach(e -> output.println(MessageFormatter.formatMessage(e, now))));
                }

                output.print("> ");
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
