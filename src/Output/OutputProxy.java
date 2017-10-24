package Output;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

/**
 * Created by Patrick on 18/10/2017.
 */
public class OutputProxy extends Colleague {
    private String colleagueCode;
    private TakeInput takeInput;
    public OutputProxy(Mediator mediator) {
        super(mediator);
        colleagueCode = "Output";
        takeInput = new TakeInput();
    }

    @Override
    public void receive(Message message) {
        switch (message.getSource()){
            case "Input":
                if (message.getAction().equals("Error"))
                    System.out.println(message.getContent());
                break;
        }
    }

    public void execute(String inText){
        Message message = new Message("Input", colleagueCode, inText, "UserInput");
        send(message);
    }
}
