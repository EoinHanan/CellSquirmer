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

    public GameProxy(Mediator mediator, Map map) {
        super(mediator);
        this.map = map;
        setColleagueCode("Game");
    }

    public void updatePlay(Play play){
        this.play = play;
    }

    @Override
    public void receive(Message message){
        FacadeUtility facade = new FacadeUtility();
        String command, direction;
        Boolean valid = true;
        String mapName;
        if (message.getSource().equals("CommandParser")){
            command = message.getAction();
            switch(command){
                case "go":
                //we have the command so now we call the Move Class
                    direction = message.getContent();
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
                    break;
                case "investigate":
                    //Call the State class

                    State state = new State();
                    this.check = state.checkState(map,play);
                    if(this.check == -1)
                        outputState("You lose, try again");
                    if(this.check == 0)
                        outputState("No update to state");
                    else if(this.check == 1)
                        outputState("You win. Congratualtions");
                    break;

                case "take":
                //Not used yet
                    break;

                case "save":
                    mapName = message.getContent();
                    try {
                        facade.writeMap(map, mapName);
                    }catch (Exception e)
                    {
                        System.out.print(e);
                    }
                    break;

                case "load":
                    mapName = message.getContent();
                    try {
                        facade.readMap(map, mapName);
                    }catch (Exception e)
                    {
                        System.out.print(e);
                    }
                    break;
            }


        }
        else if (message.getSource().equals("Attack")){

        }
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

    public void setCheck(int c){
        this.check = c;
    }

    public int getCheck() {
        return check;
    }
}
