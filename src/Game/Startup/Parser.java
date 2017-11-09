package Game.Startup;


import Game.Startup.Commands.*;
import Game.Startup.Commands.Error;

public class Parser {
    private Command[] commands;
    private String firstWord;
    private String secondWord;

    public Parser(Menu menu){
        commands = new Command[3];
        commands[0]= new LoadGameCommand(menu);
        commands[1]= new NewGameCommand(menu);
        commands[2]= new Error(menu);
    }

    public void validate(String input){
//        System.out.println("Reaching validate");
        input = normalise(input);
        if (checkList(input)) {
            split(input);
            makeCommand();
        }
        else
            commands[2].execute("There is an error with this input, try again");
    }

    private String normalise(String word){
        word = word.toLowerCase();
        return word;
    }

    private void makeCommand(){
//        System.out.println("Make command reached");
        boolean found = false;
        int i = 0;
        while(i < commands.length && !found){
//            System.out.println("Comparing " + commands[i].getName()+ " with " + firstWord);
            if (commands[i].getName().equals(firstWord))
                found = true;
            else
                i++;
        }
        if (!found)
            secondWord = "There is an error with this input, try again";

        commands[i].execute(secondWord);
    }


    private boolean checkList(String word){
        boolean valid = false;
        int i;

        for (i=0; i < commands.length && !valid; i++) {
            if (word.contains(commands[i].getName()))
                valid = true;
        }

        return valid;
    }

    private void split(String input){
//        System.out.println("Split reached");
        if (input.contains(" ")){
            if (input.indexOf(" ") == input.lastIndexOf(" ")) {
                firstWord = input.substring(0, input.indexOf(" "));
                secondWord = input.substring(input.indexOf(" ") + 1);
            }
            else {
                firstWord = input.substring(0, input.indexOf(" "));
                secondWord = input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" ") );
            }
        }
        else {
            commands[2].execute("Not enough words");
        }
    }
}
