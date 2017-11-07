package Interceptor;
import Character.CheckpointCaretaker;

//@FunctionalInterface
public interface Interceptor {

//    @Override
    void errorMessageReceiver(Context context);

    void updateMomento(ConcreteMomentoInterceptor context);
}
