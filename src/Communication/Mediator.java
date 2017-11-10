package Communication;


public interface Mediator {
    public void send(Message message, Colleague colleague);

    public void addColleague(Colleague colleague);
}
