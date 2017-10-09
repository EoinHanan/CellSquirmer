package Communication;

/**
 * Created by EoinH on 09/10/2017.
 */
public class Message {

    private String message;

    //Message code is a unique indicator to distinguish each individual message, from code is to distinguish where is it coming from, and to code is to show where is going to
    private int messageCode, fromCode, toCode;

    public Message(String message, int messageCode, int fromCode, int toCode){
        this.message = message;
        this.messageCode = messageCode;
        this.fromCode = fromCode;
        this.toCode = toCode;
    }

    public String getMessage(){
        return message;
    }
    public int getMessageCode(){
        return messageCode;
    }
    public int getFromCode(){
        return fromCode;
    }
    public int getToCode(){
        return toCode;
    }
}
