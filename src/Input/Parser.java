package Input;

import Character.Proxy;
/**
 * Created by EoinH on 27/09/2017.
 */
public class Parser{
    private String[] commandList ={"go","take","investigate"};
    private Go goCommand;
    private Take takeCommand;
    private Investigate investigateCommand;

    Proxy proxy = new Proxy();


    public Parser (){
        goCommand = new Go(proxy);
        takeCommand = new Take(proxy);
        investigateCommand = new Investigate(proxy);
    }

    public void validate(String input){
        input = normalise(input);
        if (checkList(input)) {
            makeCommand(input);
        }

    }

    private String normalise(String word){
        word = word.toLowerCase();

        return word;
    }

    private void makeCommand(String commandString){
        String firstWord = commandString.substring(0,commandString.indexOf(" "));
        String secondWord = commandString.substring(commandString.indexOf(" "));

        switch (firstWord){
            case "go":goCommand.execute(commandString); ;break;
            case "investigate":investigateCommand.execute() ;break;
            case "take":takeCommand.execute() ;break;

        }
    }

    public String[] giveCommandList(){
        return commandList;
    }

    private boolean checkList(String word){
        boolean valid = false;
        int i;

        for (i=0;i < commandList.length && valid==false;i++)
            if (word.matches(commandList[i]))
                valid =true;

        return valid;
    }

    public boolean checkEnd(String word){
        if (word.equals("End"))
            return true;
        else return false;
    }
}
