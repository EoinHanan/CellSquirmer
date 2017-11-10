package Communication;


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
