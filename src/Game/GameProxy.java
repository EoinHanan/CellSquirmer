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
        if (message.getSource().equals("input")){
            command = message.getAction();
            switch(command){
                case "go":
                //we have the command so now we call the Move Class
                    direction = message.getContent();
                    switch(direction){
                        case "north":
                            Move northMove = new Move(0, 1);
                            northMove.validateMove(0, 1, play);
                            break;
                        case "east":
                            new Move(1, 0);
                            break;
                        case "south":
                            new Move(0, -1);
                            break;
                        case "west":
                            new Move(1, 0);
                            break;
                    }
                    break;
                case "investigate":
                    //Call the State class

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
}
