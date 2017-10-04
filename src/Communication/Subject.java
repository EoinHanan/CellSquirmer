package Communication;

/**
 * Created by EoinH on 02/10/2017.
 */
public interface Subject {

    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver();

}
