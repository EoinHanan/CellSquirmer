package Character;

import Communication.Observer;

/**
 * Created by EoinH on 03/10/2017.
 */
public class Proxy implements Observer {
    private String name;
    public Proxy(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    @Override
    public void update(String Command) {
        System.out.println("Incoming command is " + Command);
    }
}
