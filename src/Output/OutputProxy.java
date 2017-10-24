package Output;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by Patrick on 18/10/2017.
 */
public class OutputProxy extends Colleague {
    private TakeInput takeInput;
    public OutputProxy(Mediator mediator) {
        super(mediator);
        setColleagueCode("Output");
        takeInput = new TakeInput();
    }
    public void lookForInput(){
        System.out.print("Looking for input");
        String userInput = takeInput.userinput();
        execute(userInput);
    }

    @Override
    public void receive(Message message) {
        switch (message.getSource()){
            case "Input":
                if (message.getAction().equals("Error"))
                    System.out.println("Output through GUI: " + message.getContent());
                break;
        }
    }

    private void execute(String inText){
        Message message = new Message("Input", this.getColleagueCode(), inText, "UserInput");
        send(message);
    }
}
