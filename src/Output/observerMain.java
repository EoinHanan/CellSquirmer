package Output;

import java.util.ArrayList;
import java.util.List;

public class observerMain implements Subject {

    private List<Observer> observer_objs_list;
    private String message;
    private boolean changed;

    public observerMain(){
        this.observer_objs_list = new ArrayList<>();
    }
    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");

            if(!observer_objs_list.contains(obj)) observer_objs_list.add(obj);

    }

    @Override
    public void unregister(Observer obj) {
        observer_objs_list.remove(obj);
    }

    @Override
    public void notifyObservers() {
        List<Observer> allObservers = null;
            if (!changed)
                return;
            allObservers = new ArrayList<>(this.observer_objs_list);
            this.changed=false;
        for (Observer obj : allObservers) {
            obj.update();
        }

    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    //print to screen , update observers
    public void outputToScreen(String msg){
        System.out.println("Message to to post to screen:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }
}