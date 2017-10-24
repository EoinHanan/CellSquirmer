package Communication;

/**
 * Created by EoinH on 04/10/2017.
 */
public abstract class Colleague{
    private Mediator mediator;
    private String colleagueCode;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;

        mediator.addColleague(this);
    }

    public void send(Message message) {
        mediator.send(message,this);
    }

    public Mediator getMediator() {return mediator;}

    public abstract void receive(Message message);

    public void setColleagueCode(String colleagueCode){
        this.colleagueCode = colleagueCode;
    }

    public String getColleagueCode(){
        return colleagueCode;
    }
}
