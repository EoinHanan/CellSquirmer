package Communication;

/**
 * Created by EoinH on 04/10/2017.
 */
public interface Mediator {
    public void send(Message message, Colleague colleague);

    public void addColleague(Colleague colleague);
}
