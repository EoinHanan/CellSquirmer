package Game;

import Communication.Message;
import Game.GameCommands.*;
import Game.GameCommands.Error;

class RequestHandler {
    private Command commands[];

    public RequestHandler(GameColleague gameProxy){
        commands = new Command[9];
        commands[0]= new Go(gameProxy);
        commands[1]= new Investigate(gameProxy);
        commands[2]= new Save(gameProxy);
        commands[3]= new Load(gameProxy);
        commands[4] = new Print(gameProxy);
        commands[5] = new Update(gameProxy);
        commands[6] = new Delete(gameProxy);
        commands[7] = new Undo(gameProxy);
        commands[8] = new Error(gameProxy);
}

    public void handle(Message message){
        boolean found = false;
        int i = 0;
        while(i < commands.length - 1 && !found){
            if (commands[i].getName().equals(message.getAction()))
                found = true;
            else
                i++;
        }
            commands[i].execute(message.getContent());
    }
}
