package Combat;

public interface Request {
    String getErrorMessage();

    void setFinalErrorMessage(String finalMessage);

    String getFinalErrorMessage();
}
