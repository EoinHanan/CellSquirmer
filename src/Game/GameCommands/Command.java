package Game.GameCommands;

/**
 * Created by EoinH on 07/11/2017.
 */
public interface Command {
    public void execute(String secondWord);
    public String getName();
}
