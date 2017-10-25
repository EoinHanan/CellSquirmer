package Game;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

public class GameProxy extends Colleague {
    private Message message;
    private Play play;

    public GameProxy(Mediator mediator, Play play) {
        super(mediator);

        setColleagueCode("Game");
    }

    public void updatePlay(Play play){
        this.play = play;
    }

    @Override
    public void receive(Message message) {
        String command, direction;
        Boolean valid = true;
        if (message.getSource().equals("input")){
            command = message.getAction();
            switch(command){
                case "go":
                //we have the command so now we call the Move Class
                    direction = message.getContent();
                    switch(direction){
                        case "north":
                            Move northMove = new Move(0, 1);
                            valid = northMove.validateMove(0, 1, play);
                            if (valid = false){
                                executeUnValid("This is not a valid move. Choose another direction.");
                            }
                            else
                                executeValid("You moved north.");

                            break;
                        case "east":
                            Move eastMove = new Move(1, 0);
                            valid = eastMove.validateMove(1, 0, play);
                            if (valid = false){
                                executeUnValid("This is not a valid move. Choose another direction.");
                            }
                            else
                                executeValid("You moved north.");
                            break;
                        case "south":
                            Move southMove = new Move(0, -1);
                            valid = southMove.validateMove(0, -1, play);
                            if (valid = false){
                                executeUnValid("This is not a valid move. Choose another direction.");
                            }
                            else
                                executeValid("You moved north.");
                            break;
                        case "west":
                            Move westMove = new Move(-1, 0);
                            valid = westMove.validateMove(-1, 0, play);
                            if (valid = false){
                                executeUnValid("This is not a valid move. Choose another direction.");
                            }
                            else
                                executeValid("You moved north.");
                            break;
                    }
                    break;
                case "investigate":
                    //Call the State class
                    int check;
                    State state = new State();
                    check = state.checkState(play);
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
            }


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

    private void executeUnValid(String inText){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputMoveResult");
        send(message);
    }

    private void outputState(String inText){
        Message message = new Message("Output", this.getColleagueCode(), inText, "OutputState");
        send(message);
    }
}
