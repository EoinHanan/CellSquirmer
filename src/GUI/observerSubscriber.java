package GUI;

public class observerSubscriber implements Observer {

    private String objName;
    private Subject observerObj;

    public observerSubscriber(String name){
        this.objName=name;
    }
    @Override
    public void update() {
        String passedMessage = (String) observerObj.getUpdate(this);
        if(passedMessage == null){
            System.out.println(objName + "no message update");
        }else
            System.out.println(objName + "message updated printing" + passedMessage);
    }

    @Override
    public void setSubject(Subject sub) {
        this.observerObj=sub;
    }

}