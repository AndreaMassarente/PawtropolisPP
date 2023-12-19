package game.util.command;

public abstract class Command {
    public abstract <T> T execute();
}
