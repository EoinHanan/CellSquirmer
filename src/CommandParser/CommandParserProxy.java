package CommandParser;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

/**
 * Created by EoinH on 24/10/2017.
 */
public class CommandParserProxy extends Colleague {
    private Message message;
    private Parser parser;

    public CommandParserProxy(Mediator mediator){
        super(mediator);

        setColleagueCode("CommandParser");
        parser = new Parser(this);
    }

    @Override
    public void receive(Message message) {
        if (message.getSource().equals("GUI") && message.getAction().equals("UserInput")){
            parser.validate(message);
        }
    }

        //message = new Message("To","From", "Content","Action");
    public void sendError(){
        System.out.println("Error pressed");
        message = new Message("GUI",this.getColleagueCode(), "Invalid Input","Error");
        this.send(message);
    }

    public void executeGo(String direction){
        System.out.println("Go pressed");
        message = new Message("Game",this.getColleagueCode(), direction,"Go");
        this.send(message);
    }
    public void executeTake(){
        System.out.println("Take pressed");
        message = new Message("Game",this.getColleagueCode(), "NULL","Take");
        this.send(message);
    }
    public void executeInvestigate(){
        System.out.println("Execute pressed");
        message = new Message("Game",this.getColleagueCode(), "NULL","Investigate");
        this.send(message);
    }
}
