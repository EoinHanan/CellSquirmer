package Input;

/**
 * Created by EoinH on 27/09/2017.
 */
public class Parser {
    private String[] commandList ={"go","take","investigate"};
    private String[] direction = {"north","south","east","west"};
    public Parser (){

    }
    public boolean validate(String input){
        input = normalise(input);
        if (checkList(input))
            return true;

        return false;
    }

    private String normalise(String word){
        word = word.toLowerCase();

        return word;
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
}
