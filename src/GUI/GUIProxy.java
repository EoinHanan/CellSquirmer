package GUI;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;


import java.util.ArrayList;

/**
 * Created by Patrick on 18/10/2017.
 */
public class GUIProxy extends Colleague{
    private TakeInput takeInput;

    public GUIProxy(Mediator mediator) {
        super(mediator);
        setColleagueCode("GUI");
        takeInput = new TakeInput();

    }


    public void lookForInput(boolean inCombat){
        InputRequest userInput = takeInput.userinput();
        execute(userInput, inCombat);
    }

    @Override
    public void receive(Message message) {
        switch (message.getSource()){
            case "CommandParser":
                if (message.getAction().equals("Error"))
                    System.out.println("Output through GUI: " + message.getContent());
                break;
            case "Game": System.out.println(message.getContent()); break;
            case "Attack": System.out.println(message.getContent());break;
        }
    }

    private void execute(boolean inCombat){
        System.out.println("In combat:" + inCombat);
        if (inCombat){
            Message message = new Message("Attack", this.getColleagueCode(), request.getInput(), "UserInput");
            send(message);
        }
        else {
            Message message = new Message("CommandParser", this.getColleagueCode(), request.getInput(), "UserInput");
            send(message);
        }
    }
    public static void inCombat(){

    }
}
