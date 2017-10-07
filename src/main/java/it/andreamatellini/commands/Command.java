package it.andreamatellini.commands;

public interface Command {
    String EXIT = "EXIT";
    String WALL = "WALL";
    String FOLLOW = "EXIT";
    void execute(String command);
}
