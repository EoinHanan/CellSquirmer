package Interceptor;
import java.util.*;


public class Dispatcher implements Interceptor {

    public static Dispatcher dispatcher;
    ArrayList interceptors;

    public Dispatcher() {
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

//    @Override
    public void errorMessageReceiver(Context context) {
        ArrayList interceptorList;

        interceptorList = (ArrayList) this.interceptors.clone();
        context.setFinalErrorMessage(context.getErrorMessage());
        MoveRequest move = new MoveRequest(getClass().getName());

        context.setFinalErrorMessage(context.getErrorMessage());
        move.printError(context.getFinalErrorMessage());


    }
}
