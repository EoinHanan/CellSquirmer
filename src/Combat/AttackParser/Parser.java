package Combat.AttackParser;

import Combat.Attack;
import Communication.Message;

public class Parser {
    private String firstWord;
    private String secondWord;

    public void validate(Message message){
        String input = message.getContent();
        input = normalise(input);
        if (input.contains("attack")) {
            split(input);
            executeAttack();
        }
    }

    private String normalise(String word){
        word = word.toLowerCase();
        return word;
    }

    private void executeAttack(){
        Attack attack = new Attack();
    }

    private void split(String input) {
        String words[] = input.split(" ");
        if (words.length == 1) {
            firstWord = input;
            secondWord = null;
        } else if (words.length == 2) {
            firstWord = words[0];
            secondWord = words[1];
        } else if (words.length == 3) {
            if (words[1].matches("mysql") || words[1].matches("oracle")) {
                firstWord = words[0];
                secondWord = words[1] + ";" + words[2];
            } else {
                firstWord = "error";
                secondWord = "error";
            }
        } else {
            firstWord = "error";
            secondWord = "error";
        }
    }
}