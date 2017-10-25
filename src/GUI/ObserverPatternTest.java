package GUI;

public class ObserverPatternTest {

    public static void main(String[] args) {
        //create subject
        observerMain observerObj = new observerMain();

        //create observers
        Observer objectObserved = new observerSubscriber("name of object");

        //register observers to the subject
        observerObj.register(objectObserved);

        //attach observer to subject
        objectObserved.setSubject(observerObj);

        //check if any update is available
        objectObserved.update();

        //now send message to subject
        observerObj.outputToScreen("message to post here");
    }

}