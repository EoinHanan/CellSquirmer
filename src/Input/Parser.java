package Input;

import Communication.Message;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Parser{
    private String[] commandList ={"go","take","investigate"};
    private Go goCommand;
    private Take takeCommand;
    private Investigate investigateCommand;
    private String firstWord;
    private String secondWord;
    InputProxy commandProxy;

    public Parser (){
        goCommand = new Go(commandProxy);
        takeCommand = new Take(commandProxy);
        investigateCommand = new Investigate(commandProxy);
    }

    public void validate(Message message){
        String input = message.getAction();
        input = normalise(input);
        if (checkList(input)) {
            split(input);
            makeCommand();
        }
        else
            System.out.println("Invalid selection");

    }

    private String normalise(String word){
        word = word.toLowerCase();
        return word;
    }

    private void makeCommand(){
        switch (firstWord){
            case "go":goCommand.execute(secondWord); System.out.println("Go command");break;
            case "investigate":investigateCommand.execute(secondWord);System.out.println("Investigate command") ;break;
            case "take":takeCommand.execute(secondWord); System.out.println("Take command") ;break;
            default:System.out.println("No command accepted");
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
            firstWord = input.substring(0,input.indexOf(" "));
            secondWord = input.substring(input.indexOf(" "));
        }
        else {
            firstWord = input;
            secondWord = "ignore";
        }
    }
}
