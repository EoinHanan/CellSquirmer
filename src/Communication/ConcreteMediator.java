package Communication;

import java.util.ArrayList;

public class ConcreteMediator implements Mediator{
    private ArrayList<Colleague> colleagues;
    public ConcreteMediator() {
        colleagues = new ArrayList<Colleague>();
    }
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }
    public void send(Message message, Colleague originator) {
        for(Colleague colleague: colleagues) {
            if(colleague != originator) {
                colleague.receive(message);
            }
        }
    }
}
