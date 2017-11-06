package Game;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;
import Character.Position;
import Game.Facade.FacadeUtility;
import World.Map;

import java.sql.SQLException;

public class GameProxy extends Colleague {
    private Message message;
    private Play play;
    private Map map;

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
        String DbType, mapName;
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
                    int check;
                    State state = new State();
                    check = state.checkState(map,play);
                    if(check == -1)
                        outputState("You lose, try again");
                    if(check == 0)
                        outputState("No update to state");
                    else if(check == 1)
                        outputState("You win. Congratualtions");
                    break;

                case "take":
                //Not used yet
                    break;

                case "save":
                    System.out.println("Reached Save: " + message.getContent());
                    String[] saveType = message.getContent().split(";");
                    DbType = saveType[0];
                    mapName = saveType[1];
                    try {
                        facade.writeMap(DbType, map, mapName);
                    }catch (Exception e)
                    {
                        System.out.print(e);
                    }
                    break;

                case "load":
                    System.out.println("Reached Load");
                    String[] loadType = message.getContent().split(";");
                    DbType = loadType[0];
                    mapName = loadType[1];
                    try {
                        facade.readMap(DbType, map, mapName);
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
    }

    private void executeValid(String inText){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputMoveResult");
        send(message);
    }

    private void executeInValid(String inText){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputMoveResult");
        send(message);
    }

    private void outputState(String inText){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputState");
        send(message);
    }
}
