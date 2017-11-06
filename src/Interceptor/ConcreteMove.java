package Interceptor;

public class ConcreteMove implements Request {

    private String Errormessage;


    private String finalErrorMessage = "";


    public ConcreteMove(String message) {
        this.Errormessage = message;
    }


    @Override
    public String getErrorMessage() {
        return Errormessage;
    }

    @Override
    public void setFinalErrorMessage(String finalMessage){
        this.finalErrorMessage = finalMessage;
    }

    @Override
    public String getFinalErrorMessage() {
        return finalErrorMessage;
    }

}