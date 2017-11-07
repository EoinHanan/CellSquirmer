package Game;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;
import Character.Position;
import Game.Facade.FacadeUtility;
import World.Map;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class GameProxy extends Colleague {
    private Message message;
    private Play play;
    private Map map;
    private int check;
    private RequestHandler requestHandler;
    private FacadeUtility facade;

    public GameProxy(Mediator mediator, Map map) {
        super(mediator);
        this.map = map;
        setColleagueCode("Game");
        requestHandler = new RequestHandler(this);
        facade = new FacadeUtility();
    }

    public void updatePlay(Play play){
        this.play = play;
    }

    @Override
    public void receive(Message message){
        if (message.getSource().equals("CommandParser")) {
            requestHandler.handle(message);
        }
    }

    public void executeGo(String direction){
        Boolean valid;
        switch(direction){
            case "north":
                Move northMove = new Move(0, 1);
                valid = northMove.validateMove(0, 1, play, map);
                if (!valid){
                    executeInValid("This is not a valid move. Choose another direction.");
                }
                else{
                    executeValid("You moved north.");
                }
                break;
            case "east":
                Move eastMove = new Move(1, 0);
                valid = eastMove.validateMove(1, 0, play, map);
                if (!valid){
                    executeInValid("This is not a valid move. Choose another direction.");
                }
                else
                    executeValid("You moved East.");
                break;
            case "south":
                Move southMove = new Move(0, -1);
                valid = southMove.validateMove(0, -1, play, map);
                if (!valid){
                    executeInValid("This is not a valid move. Choose another direction.");
                }
                else
                    executeValid("You moved South.");
                break;
            case "west":
                Move westMove = new Move(-1, 0);
                valid = westMove.validateMove(-1, 0, play, map);
                if (!valid){
                    executeInValid("This is not a valid move. Choose another direction.");
                }
                else
                    executeValid("You moved West.");
                break;
        }
    }
    public void executeInvestigate(){
        State state = new State();
        this.check = state.checkState(map,play);
        if(this.check == -1)
            outputState("You lose, try again");
        if(this.check == 0)
            outputState("No update to state");
        else if(this.check == 1)
            outputState("You win. Congratualtions");
    }

    public void executeSave(String mapName){
        try {
            facade.writeMap(map, mapName);
        }catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public void executeLoad(String mapName){
        mapName = message.getContent();
        try {
            facade.readMap(map, mapName);
        }catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public void executePrint(){
        String mapString = "\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10\n";

        for (int i =0; i < map.getSize();i++) {
            mapString += (i + 1) + "\t\t";
            for (int j = 0; j < map.getSize(); j++) {
                mapString += map.getCell(i, j).icon(play.getcX(),play.getcY()) + "\t\t";
            }
            mapString+="\n\n";
        }

        Message message = new Message("Output", this.getColleagueCode(), mapString, "Print");
        send(message);
    }

    public void sendError(){
        message = new Message("Output","From", "Content","Action");
        this.send(message);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void executeValid(String inText){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputMoveResult");
        send(message);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void executeInValid(String inText){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputMoveResult");
        send(message);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void outputState(String inText){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputState");
        send(message);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCheck() {
        return check;
    }
}
