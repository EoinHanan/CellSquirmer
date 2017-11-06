package Combat;

@FunctionalInterface
public interface Interceptor {

    void errorMessageReceiver(Request context);
}