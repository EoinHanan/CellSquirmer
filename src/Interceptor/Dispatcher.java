package Interceptor;
import java.util.*;


public class Dispatcher implements Interceptor {

    private static Dispatcher dispatcher;
    ArrayList interceptors;

    private Dispatcher() {
        interceptors = new ArrayList();
    }

    public static Dispatcher getInstance() {
        if (dispatcher == null) {
            dispatcher = new Dispatcher();
        }
        return dispatcher;
    }

    public void registerErrorMessageInterceptor(Interceptor InterceptorObject) {
        interceptors.add(InterceptorObject);

    }

    public  void unregisterErrorMessageInterceptor(Interceptor InterceptorObject) {

        interceptors.remove(InterceptorObject);
    }

    @Override
    public void errorMessageReceiver(Request context) {
        ArrayList interceptorList;

        interceptorList = (ArrayList) this.interceptors.clone();
        context.setFinalErrorMessage(context.getErrorMessage());
        Move move = new Move(getClass().getName());

        context.setFinalErrorMessage(context.getErrorMessage());
        move.printError(context.getFinalErrorMessage());


    }
}
