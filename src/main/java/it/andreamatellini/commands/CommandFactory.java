package it.andreamatellini.commands;

public class CommandFactory {
    public static Command getCommand(String type, String command) {
        if(type == null){
            return null;
        }

        //TODO estrarre i parametri dalla linea di comando
        String user = "";
        String param = "";

        if(type.equals(CommandType.EXIT)) {
            return new ExitCommand();
        }
        else if(type.equals(CommandType.WALL)) {
            return new WallCommand(user);
        }
        else if(type.equals(CommandType.FOLLOW)) {
            return new FollowCommand(user, param);
        }
        else if(type.equals(CommandType.POST)) {
            return new PostCommand(user, param);
        }
        else if(type.equals(CommandType.READ)) {
            return new ReadCommand(user);
        }

        return null;
    }
}
