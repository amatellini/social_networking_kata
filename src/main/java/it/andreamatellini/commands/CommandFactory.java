package it.andreamatellini.commands;

public class CommandFactory {
    public static Command getCommand(String type) {
        if(type == null){
            return null;
        }

        if(type.equals(Command.EXIT)){
            return new ExitCommand();
        } else if(type.equals(Command.WALL)){
            return new WallCommand();
        } else if(type.equals(Command.FOLLOW)){
            return new FollowCommand();
        }

        return null;
    }
}
