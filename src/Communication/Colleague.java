package Communication;

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

    public abstract void receive(Message message);

    public void setColleagueCode(String colleagueCode){
        this.colleagueCode = colleagueCode;
    }

    public String getColleagueCode(){
        return colleagueCode;
    }
}
