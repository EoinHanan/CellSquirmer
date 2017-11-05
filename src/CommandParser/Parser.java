package CommandParser;

import Communication.Message;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Parser{
    private Command[] commands;
    private String firstWord;
    private String secondWord;

    public Parser (CommandParserProxy commandParserProxy){
        commands = new Command[6];
        commands[0]= new Go(commandParserProxy);
        commands[1]= new Take(commandParserProxy);
        commands[2]= new Investigate(commandParserProxy);
        commands[3]= new Save(commandParserProxy);
        commands[4]= new Load(commandParserProxy);
        commands[5]= new Error(commandParserProxy);

    }

    public void validate(Message message){
        String input = message.getContent();
        input = normalise(input);
        if (checkList(input)) {
            split(input);
            makeCommand();
        }
        else
            commands[5].execute("");

    }

    private String normalise(String word){
        word = word.toLowerCase();
        return word;
    }

    private void makeCommand(){
        boolean found = false;
        int i = 0;
        for (;i < commands.length && !found;i++)
            if (commands[i].getName().equals(firstWord))
                found = true;

        commands[i].execute(secondWord);
    }


    private boolean checkList(String word){
        boolean valid = false;
        int i;

        for (i=0;i < commands.length && valid==false;i++)
            if (word.contains(commands[i].getName()))
                valid =true;

        return valid;
    }

    private void split(String input){
        if (input.indexOf(" ") > -1){
            if (input.indexOf(" ") == input.lastIndexOf(" ")) {
                firstWord = input.substring(0, input.indexOf(" "));
                secondWord = input.substring(input.indexOf(" ") + 1);
            }
            else {

                firstWord = "Error";
            }

        }
        else {
            firstWord = input;
            secondWord = "ignore";
        }
    }
}