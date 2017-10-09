package Communication;

/**
 * Created by EoinH on 04/10/2017.
 */
public interface Mediator {
    public void send(int code, String firstWord,String secondWord);
    public void receive(int code, String firstWord,String secondWord);
    public void addColleague(Colleague colleague);
}
