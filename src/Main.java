import java.util.Scanner;
import Output.TakeInput;
/**
 * Created by EoinH on 28/09/2017.
 */
public class Main {
    public static void main(String [] args){
        TakeInput input = new TakeInput();
        String usertext = input.userinput();
        System.out.println(usertext);

    }
}
