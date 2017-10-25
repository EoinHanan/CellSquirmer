package CommandParser;

import Communication.Message;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Parser{
    private String[] commandList ={"go","take","investigate"};
    private Go goCommand;
    private Take takeCommand;
    private Investigate investigateCommand;
    private Error errorCommand;
    private String firstWord;
    private String secondWord;

    public Parser (CommandParserProxy commandParserProxy){
        goCommand = new Go(commandParserProxy);
        takeCommand = new Take(commandParserProxy);
        investigateCommand = new Investigate(commandParserProxy);
        errorCommand = new Error(commandParserProxy);
    }

    public void validate(Message message){
        String input = message.getContent();
        input = normalise(input);
        if (checkList(input)) {
            split(input);
            makeCommand();
        }
        else
            errorCommand.execute("");

    }

    private String normalise(String word){
        word = word.toLowerCase();
        return word;
    }

    private void makeCommand(){
        switch (firstWord){
            case "go":goCommand.execute(secondWord);break;
            case "investigate":investigateCommand.execute(secondWord) ;break;
            case "take":takeCommand.execute(secondWord) ;break;
            default:errorCommand.execute("Too many words");
        }
    }

    public String[] giveCommandList(){
        return commandList;
    }

    private boolean checkList(String word){
        boolean valid = false;
        int i;

        for (i=0;i < commandList.length && valid==false;i++)
            if (word.contains(commandList[i]))
                valid =true;

        return valid;
    }

    private void split(String input){
        if (input.indexOf(" ") > -1){
            if (input.indexOf(" ") == input.lastIndexOf(" ")) {
                firstWord = input.substring(0, input.indexOf(" "));
                secondWord = input.substring(input.indexOf(" "));
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
