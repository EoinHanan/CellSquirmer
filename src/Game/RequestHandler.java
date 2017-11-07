package Game;

import Communication.Message;
import Game.GameCommands.*;

import java.util.Map;

/**
 * Created by EoinH on 07/11/2017.
 */
class RequestHandler {
    private Command commands[];

    public RequestHandler(GameProxy gameProxy){
        commands = new Command[5];
        commands[0]= new Go(gameProxy);
        commands[1]= new Investigate(gameProxy);
        commands[2]= new Save(gameProxy);
        commands[3]= new Load(gameProxy);
        commands[4] = new Print(gameProxy);
    }

    public void handle(Message message){
        boolean found = false;
        int i = 0;
        while(i < commands.length && !found){
            if (commands[i].getName().equals(message.getAction()))
                found = true;
            else
                i++;
        }

        commands[i].execute(message.getContent());
    }
}
