package Interceptor;

public interface Context {

    String getErrorMessage();

    void setFinalErrorMessage(String finalMessage);

    String getFinalErrorMessage();

    void setX(int X);

    void setY(int Y);

    int getX();

    int getY();




}