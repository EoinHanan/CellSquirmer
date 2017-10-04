import Input.CommandLine;
import Character.Proxy;

/**
 * Created by EoinH on 28/09/2017.
 */
public class Main {
    public static void main(String [] args){
        Proxy proxy = new Proxy("Name");
        CommandLine input = new CommandLine(proxy);
    }
}
