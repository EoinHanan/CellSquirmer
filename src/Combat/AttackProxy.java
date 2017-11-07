package Combat;

import Combat.AttackParser.Parser;
import Communication.Mediator;
import Communication.Message;
import Communication.Colleague;
import Prototype.Enemy;
import World.Cell;

public class AttackProxy extends Colleague{
    private Attack currentEnemy;
    private Enemy enemy;
    private Parser parser;
    private boolean inCombat;


    public AttackProxy (Mediator mediator){
        super(mediator);
        setColleagueCode("Attack");
        inCombat = false;
        //currentEnemy = new Attack(enemy);
    }

    @Override
    public void receive(Message message) {
        if(message.getDestination().equals(this.getColleagueCode()) && message.getAction().equals("Attack")) {
            if (parser.validate(message)) {
                this.send(new Message("GUI", this.getColleagueCode(), "Damage done, enemy has " + currentEnemy.getHealth(), "Attack Print"));
                if (currentEnemy.getHealth() == 0) {
                    this.send(new Message("Game", this.getColleagueCode(), "Enemy Defeated", "Combat End"));
                    inCombat = false;
                }
            }
            else
                this.send(new Message("GUI", this.getColleagueCode(), "Invalid inpu", "Invalid"));
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
