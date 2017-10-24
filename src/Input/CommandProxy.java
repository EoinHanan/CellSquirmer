package Input;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

/**
 * Created by EoinH on 24/10/2017.
 */
public class CommandProxy extends Colleague {
    private Message message;
    private Parser parser;

    CommandProxy (Mediator mediator){
        super(mediator);
    }

    @Override
    public void receive(Message message) {
        if (message.getSource().equals("Output") && message.getAction().equals("Input")){
            parser.validate(message);
        }
    }

        //message = new Message("To","From", "Content","Action");
    public void sendError(){
        message = new Message("Output","From", "Content","Action");
        this.send(message);
    }

    public void executeGo(){
        message = new Message("","From", "Content","Action");
        this.send(message);
    }
    public void executeTake(){
        message = new Message("To","From", "Content","Action");
        this.send(message);
    }
    public void executeInvestigate(){
        message = new Message("To","From", "Content","Action");
        this.send(message);
    }
}
