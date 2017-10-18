package Communication;

/**
 * Created by EoinH on 11/10/2017.
 */
public class Message {
    private String destination;
    private String source;
    private String content;
    private String action;

    public Message(String destination, String source, String content, String action){
        this.destination = destination;
        this.source = source;
        this.content = content;
        this.action = action;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }
    public void setSource(String source){
        this.source = source;
    }
    public void setContent(String content){
        this.content= content;
    }
    public void setAction(String action){
        this.action= action;
    }

    public String getDestination(){
        return destination;
    }
    public String getSource(){
        return source;
    }
    public String getContent(){
        return content;
    }
    public String getAction(){
        return action;
    }
}
