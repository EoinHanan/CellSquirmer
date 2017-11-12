package CommandParser.Combat;

import Communication.Mediator;
import Communication.Message;
import Communication.Colleague;
import Prototype.Enemy;

public class AttackColleague extends Colleague{
    private Enemy enemy;
    private Parser parser;
    private boolean inCombat;


    public AttackColleague(Mediator mediator){
        super(mediator);
        setColleagueCode("Attack");
        inCombat = false;
        parser = new Parser();
    }

    @Override
    public void receive(Message message) {
        if(message.getDestination().equals(this.getColleagueCode()) && message.getAction().equals("InCombat")) {
            if (parser.validate(message)) {
                enemy.setHealth(enemy.getHealth() - 1);
                this.send(new Message("GUI", this.getColleagueCode(), "Damage done, enemy has " + enemy.getHealth(), "Attack Print"));

                if (enemy.getHealth() == 0) {
                    this.send(new Message("Game", this.getColleagueCode(), "Enemy Defeated", "CommandParser.Combat End"));
                    inCombat = false;
                }
            }
            else
                this.send(new Message("GUI", this.getColleagueCode(), "Invalid input", "Invalid"));
        }
    }
    public void setCurrentEnemy(Enemy enemy){
        this.enemy = enemy;
        inCombat = true;
    }
    public boolean checkCombat(){
        return inCombat;
    }
}
