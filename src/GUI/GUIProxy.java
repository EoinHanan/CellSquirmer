package GUI;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;
import Interceptor.Interceptor;
import Interceptor.Request;

import java.util.ArrayList;

/**
 * Created by Patrick on 18/10/2017.
 */
public class GUIProxy extends Colleague{
    private TakeInput takeInput;
    ArrayList interceptors;

    public GUIProxy(Mediator mediator) {
        super(mediator);
        setColleagueCode("GUI");
        takeInput = new TakeInput();
        interceptors = new ArrayList();

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

    private void execute(InputRequest request, boolean inCombat){
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
