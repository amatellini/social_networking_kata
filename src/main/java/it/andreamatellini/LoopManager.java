package it.andreamatellini;

import it.andreamatellini.commands.Command;
import it.andreamatellini.commands.CommandParser;

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
        try {
            output.print("> ");
            while(true){
                String line = bufferedReader.readLine();

                Optional<Command> command = CommandParser.parse(line);

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
