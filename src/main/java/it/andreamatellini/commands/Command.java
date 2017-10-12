package it.andreamatellini.commands;

import it.andreamatellini.message.Message;

import java.util.List;

public interface Command {
    List<Message> execute();
}
