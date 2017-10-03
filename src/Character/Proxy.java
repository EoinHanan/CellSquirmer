package Character;

/**
 * Created by EoinH on 03/10/2017.
 */
public class Proxy implements Observer {

    @Override
    public void update(String Command) {
        System.out.println("Incoming command is " + Command);
    }
}
