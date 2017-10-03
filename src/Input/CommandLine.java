package Input;

import java.util.Scanner;

/**
 * Created by EoinH on 27/09/2017.
 */
public class CommandLine {
    private Scanner in;
    private String ask = "Enter input:", invalid = "Invalid, no input";
    private String input;
    private static Parser parser = new Parser();

    public CommandLine() {
        in = new Scanner(System.in);
        boolean willContinue =true;


        while (willContinue) {
            System.out.println(ask);
            input = in.nextLine();

            willContinue = parser.checkEnd(input);
            if (!willContinue)
                break;

            parser.validate(input);
        }
    }
}
