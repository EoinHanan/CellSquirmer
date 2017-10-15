package Communication;

import java.util.ArrayList;

/**
 * Created by EoinH on 11/10/2017.
 */
public class ConcreteMediator implements Mediator{
    private ArrayList<Colleague> colleagues;
    public ConcreteMediator() {
        colleagues = new ArrayList<Colleague>();
    }
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }
    public void send(Message message, Colleague originator) {
        //let all other screens know that this screen has changed
        for(Colleague colleague: colleagues) {
            //don't tell ourselves
            if(colleague != originator) {
                colleague.receive(message);
            }
        }
    }
}
