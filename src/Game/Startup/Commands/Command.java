package Game.Startup.Commands;

/**
 * Created by EoinH on 08/11/2017.
 */
public interface Command {
    public void execute(String secondWord);
    public String getName();
}

