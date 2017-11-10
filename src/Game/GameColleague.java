package Game;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;
import Facade.FacadeUtility;
import World.Map;

import java.util.concurrent.TimeUnit;

public class GameColleague extends Colleague {
    private Message message;
    private Play play;
    private Map map;
    private int check;
    private RequestHandler requestHandler;
    private MoveRequestHandler moveRequestHandler;
    private FacadeUtility facade;
    private String mapName;

    public GameColleague(Mediator mediator, Map map) {
        super(mediator);
        this.map = map;
        setColleagueCode("Game");
        requestHandler = new RequestHandler(this);
        moveRequestHandler = new MoveRequestHandler(this);
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
        moveRequestHandler.handle(direction, map ,play );

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
        try {
            facade.readMap(map, mapName);
        }catch (Exception e)
        {
            System.out.print(e);
        }
        this.mapName = mapName;
    }

    public void executeUpdate(String mapName){
        try {
            facade.updateMap(map, mapName);
        }catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public void executeDelete(String mapName){
        try {
            facade.deleteMap(mapName);
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
        //Push it real
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

    public void sendCombatMessage(){
        //Content is blank so user can send the attack themselves but we're still put in combat
        Message message = new Message("Attack", this.getColleagueCode(), "You have encountered an enemy", "In combat");
        send(message);
    }

    public void executeValid(String inText, Move move){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputMoveResult");
        send(message);
        play.setPosition(move.getPostition());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void executeInValid(String inText){
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

    public String getMapName(){
        return mapName;
    }
}
