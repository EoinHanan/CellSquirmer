package Interceptor;

public class ConcreteInterceptor implements Context {

    private String Errormessage;


    private String finalErrorMessage = "";


    public ConcreteInterceptor(String message) {
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