package Game;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

public class GameProxy extends Colleague {
    private Message message;

    public GameProxy(Mediator mediator) {
        super(mediator);
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
                            break;
                        case "east":
                            break;
                        case "south":
                            break;
                        case "west":
                            break;
                    }
                    break;
                case "investigate":
                    //Call the State class
                    break;

                //Call the State class
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
