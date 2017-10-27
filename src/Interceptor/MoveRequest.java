package Interceptor;

public interface MoveRequest {

    String getErrorMessage();

    void setFinalErrorMessage(String finalMessage);

    String getFinalErrorMessage();

}