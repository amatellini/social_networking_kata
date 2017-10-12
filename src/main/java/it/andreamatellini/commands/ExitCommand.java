package it.andreamatellini.commands;

import it.andreamatellini.message.Message;

import java.util.Collections;
import java.util.List;

public class ExitCommand implements Command {
    @Override
    public List<Message> execute() {
        System.out.println("Hasta la vista baby!");
        System.exit(0);
        return Collections.emptyList();
    }
}
