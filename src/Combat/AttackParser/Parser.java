package Combat.AttackParser;

import Combat.Attack;
import Communication.Message;

public class Parser {


    public boolean validate(Message message){
        String input = message.getContent();
        input = input.toLowerCase();
        if (input.contains("attack")) {
            return true;
        }
        return false;
    }
}