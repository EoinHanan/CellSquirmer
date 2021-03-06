package GUI;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;


import java.util.ArrayList;

public class GUIColleague extends Colleague{
    private TakeInput takeInput;
    private Printer printer;

    public GUIColleague(Mediator mediator) {
        super(mediator);
        setColleagueCode("GUI");
        takeInput = new TakeInput();
        printer = new Printer();
    }

    public void print(String text){
        printer.print(text);
    }

    public void lookForInput(boolean inCombat){
        String userInput = takeInput.userinput();
        execute(userInput, inCombat);
    }

    @Override
    public void receive(Message message) {
        switch (message.getSource()){
            case "CommandParser":
                if (message.getAction().equals("Error"))
                    printer.print("Output through GUI: " + message.getContent());
                break;
            case "Game": printer.print(message.getContent()); break;
            case "Attack": printer.print(message.getContent());break;
        }
    }

    private void execute(String input, boolean inCombat){
        if (inCombat){
            Message message = new Message("Attack", this.getColleagueCode(), input, "InCombat");
            send(message);
        }
        else {
            Message message = new Message("CommandParser", this.getColleagueCode(), input, "UserInput");
            send(message);
        }
    }
}
