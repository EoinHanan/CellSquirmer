package Interceptor;

@FunctionalInterface
public interface MoveInterceptor {

    void errorMessageReceiver(MoveRequest context);
}
