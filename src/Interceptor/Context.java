package Interceptor;

public interface Context {

    String getErrorMessage();

    void setFinalErrorMessage(String finalMessage);

    String getFinalErrorMessage();

}