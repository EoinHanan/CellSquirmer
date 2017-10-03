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

        /*
        int inputNumber=howMany(input);
        if (inputNumber == 0){
            System.out.println();

        }
        else if(inputNumber > 1 ) {
            divide(input);
        }

        if(parser.validate(input))
            System.out.println("Valid input");
        else
            System.out.println("Invalid input");
    }
    private Command sort(String firstInput, String secondInput){
        Command command = new Go("");

        switch (firstInput) {
            case "go": command = new Go(secondInput);break;
            case "investigate": command = new Investigate();break;
            case "take": command = new Take();break;

        }
        return command;
    }

    private int howMany(String line){

        words = line.split(" ");
        return words.length;
    }

    private String[] divide(String line){
        String words[];

        words = line.split(" ");

        return words;
    }

}*/
