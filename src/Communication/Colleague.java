package Communication;

/**
 * Created by EoinH on 04/10/2017.
 */
public abstract class Colleague {
    private Mediator mediator;
    private int colleagueCode;

    public Colleague(Mediator mediator){
        this.mediator = mediator;

        mediator.addColleague(this);
    }
    public void send(String firstWord,String secondWord){
        mediator.send(colleagueCode,firstWord,secondWord);
    }
    public void receive(int code, String firstWord,String secondWord){
        mediator.receive(colleagueCode,firstWord,secondWord);
    }
    public void setColleagueCode(int colleagueCode){
        this.colleagueCode = colleagueCode;
    }
}
