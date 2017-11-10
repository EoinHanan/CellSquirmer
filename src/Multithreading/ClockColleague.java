package Multithreading;

import Communication.Colleague;
import Communication.Mediator;
import Communication.Message;

import java.util.concurrent.TimeUnit;

public class ClockColleague extends Colleague {
    Clock clock;
    public ClockColleague(Mediator mediator){
        super(mediator);
        clock = new Clock();
        setColleagueCode("Clock");
    }
    @Override
    public void receive(Message message) {
        if(message.getDestination().equals(this.getColleagueCode()) && message.getAction().equals("Time Request")) {
            this.send(new Message("GUI", this.getColleagueCode(), clock.getTime().toString(), "Time Print"));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop(){
        clock.stopThread();
    }
}
