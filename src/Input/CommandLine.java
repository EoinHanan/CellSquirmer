package Input;

import java.util.Scanner;

/**
 * Created by EoinH on 27/09/2017.
 */
public class CommandLine {
    Scanner in;
    String ask = "Enter input\n";
    String input;
    String words[];
    static Parser parser;
    public CommandLine(){
        Scanner in = new Scanner(System.in);
        System.out.print(ask);
        input =in.nextLine();
        int inputNumber=howMany(input);
        if (inputNumber == 0){
            System.out.print("Invalid, no input");

        }
        else if(inputNumber > 1 ) {
            divide(input);
        }

        parser.validate(input);

        if(words.length == 1){

        }else if(words.length > 2){

        }else{
            System.out.print("Too many words chosen");
        }
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

}
