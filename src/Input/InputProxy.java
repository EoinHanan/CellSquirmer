package Input;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

/**
 * Created by EoinH on 24/10/2017.
 */
public class InputProxy extends Colleague {
    private Message message;
    private Parser parser;

    public InputProxy(Mediator mediator){
        super(mediator);
        setColleagueCode("Input");
        parser = new Parser();
    }

    @Override
    public void receive(Message message) {
        if (message.getSource().equals("Output") && message.getAction().equals("UserInput")){
            parser.validate(message);
        }
    }

        //message = new Message("To","From", "Content","Action");
    public void sendError(){
        message = new Message("Output",this.getColleagueCode(), "Invalid Input","Error");
        this.send(message);
    }

    public void executeGo(String direction){
        message = new Message("Game",this.getColleagueCode(), direction,"Go");
        this.send(message);
    }
    public void executeTake(){
        message = new Message("Game",this.getColleagueCode(), "NULL","Take");
        this.send(message);
    }
    public void executeInvestigate(){
        message = new Message("Game",this.getColleagueCode(), "NULL","Investigate");
        this.send(message);
    }
}
