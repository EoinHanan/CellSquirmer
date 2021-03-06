package CommandParser;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

import java.util.concurrent.TimeUnit;

public class CommandParserColleague extends Colleague {
    private Message message;
    private Parser parser;

    public CommandParserColleague(Mediator mediator){
        super(mediator);

        setColleagueCode("CommandParser");
        parser = new Parser(this);
    }

    @Override
    public void receive(Message message) {
        if (message.getSource().equals("GUI") && message.getDestination().equals(this.getColleagueCode())){
            parser.validate(message);
        }
    }

    public void sendError(){
        message = new Message("GUI",this.getColleagueCode(), "Invalid Input","Error");
        this.send(message);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void executeGo(String direction){
        message = new Message("Game",this.getColleagueCode(), direction,"go");
        this.send(message);
    }
    public void executeInvestigate(){
        message = new Message("Game",this.getColleagueCode(), "NULL","investigate");
        this.send(message);
    }
    public void executeSave(String messageText){
        message = new Message("Game",this.getColleagueCode(), messageText,"save");
        this.send(message);
    }public void executeLoad(String messageText){
        message = new Message("Game",this.getColleagueCode(), messageText,"load");
        this.send(message);
    }
    public void executePrint(){
        message = new Message("Game",this.getColleagueCode(),"" ,"print");
        this.send(message);
    }
    public void executeUpdate(String messageText){
        message = new Message("Game",this.getColleagueCode(), messageText,"update");
        this.send(message);
    }
    public void executeDelete(String messageText){
        message = new Message("Game",this.getColleagueCode(), messageText,"delete");
        this.send(message);
    }
    public void executeUndo(String messageText){
        message = new Message("Game",this.getColleagueCode(), messageText,"undo");
        this.send(message);
    }
}