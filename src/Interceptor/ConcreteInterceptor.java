package Interceptor;


public class ConcreteInterceptor implements Context {

    private String Errormessage;
    private int x;
    private int y;


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

    public void setX(int X){ x = X; }

    public void setY(int Y ){y = Y;}

    public int getX(){

        return x; }

    public int getY(){return y;}

}