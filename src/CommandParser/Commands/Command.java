package CommandParser.Commands;

public interface Command {
    public void execute(String secondWord);
    public String getName();
}
